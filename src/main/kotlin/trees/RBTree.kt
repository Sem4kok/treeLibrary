package trees

import BinaryTree

import treeNodes.Color
import treeNodes.RBTreeNode

class RBTree<K : Comparable<K>, V> : BinaryTree<K, V, RBTreeNode<K, V>>() {

    val NilNode = RBTreeNode<Int,Int>(0,0)
    fun searchNode(key: K): RBTreeNode<K, V>? {
        var node: RBTreeNode<K, V>? = root
        while (node != null) {
            node = if (key == node.key) {
                return node
            } else if (key < node.key) {
                node.left
            } else {
                node.right
            }
        }

        return null
    }

    // -- Insertion ----------------------------------------------------------------------------------
    override fun insert(key: K, data: V) {
        var node: RBTreeNode<K, V>? = root
        var parent: RBTreeNode<K, V>? = null

        // Traverse the tree to the left or right depending on the key
        while (node != null) {
            parent = node
            node = if (key < node.key) {
                node.left
            } else if (key > node.key) {
                node.right
            } else {
                throw IllegalArgumentException("BST already contains a node with key $key")
            }
        }

        // Insert new node
        val newNode: RBTreeNode<K, V> = RBTreeNode<K, V>(key, data)
        newNode.color = Color.RED
        if (parent == null) {
            root = newNode
        } else if (key < parent.key) {
            parent.left = newNode
        } else {
            parent.right = newNode
        }
        newNode.parent = parent

        fixRedBlackPropertiesAfterInsert(newNode)
    }

    // Ignore SonarCloud complains about commented code line 70.
    private fun fixRedBlackPropertiesAfterInsert(node: RBTreeNode<K, V>) {
        var parent: RBTreeNode<K, V> = node.parent
            ?: // Uncomment the following line if you want to enforce black roots (rule 2):
            // node.color = Color.BLACK;
            return

        // Case 1: Parent is null, we've reached the root, the end of the recursion

        // Parent is black --> nothing to do
        if (parent.color === Color.BLACK) {
            return
        }

        // From here on, parent is red
        val grandparent: RBTreeNode<K, V>? = parent.parent

        // Case 2:
        // Not having a grandparent means that parent is the root. If we enforce black roots
        // (rule 2), grandparent will never be null, and the following if-then block can be
        // removed.
        if (grandparent == null) {
            // As this method is only called on red nodes (either on newly inserted ones - or -
            // recursively on red grandparents), all we have to do is to recolor the root black.
            parent.color = Color.BLACK
            return
        }

        // Get the uncle (maybe null/nil, in which case its color is Color.BLACK)
        val uncle: RBTreeNode<K, V>? = getUncle(parent)

        // Case 3: Uncle is red -> recolor parent, grandparent and uncle
        if (uncle != null && uncle.color === Color.RED) {
            parent.color = Color.BLACK
            grandparent.color = Color.RED
            uncle.color = Color.BLACK

            // Call recursively for grandparent, which is now red.
            // It might be root or have a red parent, in which case we need to fix more...
            fixRedBlackPropertiesAfterInsert(grandparent)
        } else if (parent === grandparent.left) {
            // Case 4a: Uncle is black and node is left->right "inner child" of its grandparent
            if (node === parent.right) {
                rotateLeft(parent)

                // Let "parent" point to the new root node of the rotated sub-tree.
                // It will be recolored in the next step, which we're going to fall-through to.
                parent = node
            }

            // Case 5a: Uncle is black and node is left->left "outer child" of its grandparent
            rotateRight(grandparent)

            // Recolor original parent and grandparent
            parent.color = Color.BLACK
            grandparent.color = Color.RED
        } else {
            // Case 4b: Uncle is black and node is right->left "inner child" of its grandparent
            if (node === parent.left) {
                rotateRight(parent)

                // Let "parent" point to the new root node of the rotated sub-tree.
                // It will be recolored in the next step, which we're going to fall-through to.
                parent = node
            }

            // Case 5b: Uncle is black and node is right->right "outer child" of its grandparent
            rotateLeft(grandparent)

            // Recolor original parent and grandparent
            parent.color = Color.BLACK
            grandparent.color = Color.RED
        }
    }

    private fun getUncle(parent: RBTreeNode<K, V>): RBTreeNode<K, V>?{
        val grandparent: RBTreeNode<K, V>? = parent.parent
        return if (grandparent?.left === parent) {
            grandparent.right
        } else if (grandparent?.right === parent) {
            grandparent.left
        } else {
            throw IllegalStateException("Parent is not a child of its grandparent")
        }
    }

    // -- Deletion -----------------------------------------------------------------------------------
    override fun remove(key: K) {
        var node: RBTreeNode<K, V>? = root

        // Find the node to be deleted
        while (node != null && node.key !== key) {
            // Traverse the tree to the left or right depending on the key
            node = if (key < node.key) {
                node.left
            } else {
                node.right
            }
        }

        // RBTreeNode<K, V> not found?
        if (node == null) {
            return
        }

        // At this point, "node" is the node to be deleted

        // In this variable, we'll store the node at which we're going to start to fix the R-B
        // properties after deleting a node.
        val movedUpNode: RBTreeNode<K, V>?
        val deletedNodeColor: Color

        // RBTreeNode<K, V> has zero or one child
        if (node.left == null || node.right == null) {
            movedUpNode = deleteNodeWithZeroOrOneChild(node)
            deletedNodeColor = node.color
        } else {
            // Find minimum node of right subtree ("inorder successor" of current node)
            val inOrderSuccessor: RBTreeNode<K, V> = findMinimum(node.right as RBTreeNode)

            // Copy inorder successor's key to current node (keep its color!)
            node.key = inOrderSuccessor.key

            // Delete inorder successor just as we would delete a node with 0 or 1 child
            movedUpNode = deleteNodeWithZeroOrOneChild(inOrderSuccessor)
            deletedNodeColor = inOrderSuccessor.color
        }

        if (deletedNodeColor == Color.BLACK) {
            fixRedBlackPropertiesAfterDelete(movedUpNode)

            // Remove the temporary NIL node
            if (movedUpNode == NilNode) {
                replaceParentsChild(movedUpNode.parent, movedUpNode, null)
            }
        }
    }

    private fun deleteNodeWithZeroOrOneChild(node: RBTreeNode<K, V>): RBTreeNode<K, V>? {
        // RBTreeNode<K, V> has ONLY a left child --> replace by its left child
        if (node.left != null) {
            replaceParentsChild(node.parent, node, node.left)
            return node.left // moved-up node
        } else if (node.right != null) {
            replaceParentsChild(node.parent, node, node.right)
            return node.right // moved-up node
        } else {
            replaceParentsChild(node.parent, node, null)
            return null
        }
    }

    private fun findMinimum(node: RBTreeNode<K, V>): RBTreeNode<K, V> {
        var node: RBTreeNode<K, V> = node
        while (node.left != null)  {
            node = node.left!!
        }
        return node
    }

    // Ignore SonarCloud complains about commented code line 256.
    private fun fixRedBlackPropertiesAfterDelete(node: RBTreeNode<K, V>?) {
        // Case 1: Examined node is root, end of recursion
        if (node === root) {
            // Uncomment the following line if you want to enforce black roots (rule 2):
            // node.color = Color.BLACK;
            return
        }

        var sibling: RBTreeNode<K, V>? = getSibling(node)

        // Case 2: Red sibling
        if (sibling?.color === Color.RED) {
            handleRedSibling(node, sibling)
            sibling = getSibling(node) // Get new sibling for fall-through to cases 3-6
        }

        // Cases 3+4: Black sibling with two black children
        if (isBlack(sibling?.left) && isBlack(sibling?.right)) {
            sibling?.color = Color.RED

            // Case 3: Black sibling with two black children + red parent
            if (node?.parent?.color === Color.RED) {
                node?.parent?.color = Color.BLACK
            } else {
                fixRedBlackPropertiesAfterDelete(node?.parent)
            }
        } else {
            handleBlackSiblingWithAtLeastOneRedChild(node, sibling)
        }
    }

    private fun handleRedSibling(node: RBTreeNode<K, V>?, sibling: RBTreeNode<K, V>) {
        // Recolor...
        sibling.color = Color.BLACK
        node?.parent?.color = Color.RED

        // ... and rotate
        if (node === node?.parent?.left) {
            rotateLeft(node?.parent)
        } else {
            rotateRight(node?.parent)
        }
    }

    private fun handleBlackSiblingWithAtLeastOneRedChild(node: RBTreeNode<K, V>?, sibling: RBTreeNode<K, V>?) {
        var sibling: RBTreeNode<K, V>? = sibling
        val nodeIsLeftChild = node === node?.parent?.left

        // Case 5: Black sibling with at least one red child + "outer nephew" is black
        // --> Recolor sibling and its child, and rotate around sibling
        if (nodeIsLeftChild && isBlack(sibling?.right)) {
            sibling?.left?.color = Color.BLACK
            sibling?.color = Color.RED
            rotateRight(sibling)
            sibling = node?.parent?.right
        } else if (!nodeIsLeftChild && isBlack(sibling?.left)) {
            sibling?.right?.color = Color.BLACK
            sibling?.color = Color.RED
            rotateLeft(sibling)
            sibling = node?.parent?.left
        }

        // Fall-through to case 6...

        // Case 6: Black sibling with at least one red child + "outer nephew" is red
        // --> Recolor sibling + parent + sibling's child, and rotate around parent
        val ParentColor = node?.parent?.color ?: throw IllegalStateException("Ya daun")
        sibling?.color = ParentColor
        node.parent?.color = Color.BLACK
        if (nodeIsLeftChild) {
            sibling?.right?.color = Color.BLACK
            rotateLeft(node.parent)
        } else {
            sibling?.left?.color = Color.BLACK
            rotateRight(node.parent)
        }
    }

    private fun getSibling(node: RBTreeNode<K, V>?): RBTreeNode<K, V>? {
        val parent: RBTreeNode<K, V>? = node?.parent
        return if (node === parent?.left) {
            parent?.right
        } else if (node === parent?.right) {
            parent?.left
        } else {
            throw IllegalStateException("Parent is not a child of its grandparent")
        }
    }

    private fun isBlack(node: RBTreeNode<K, V>?): Boolean {
        return node == null || node.color === Color.BLACK
    }

    // -- Helpers for insertion and deletion ---------------------------------------------------------
    private fun rotateRight(node: RBTreeNode<K, V>?) {
        val parent: RBTreeNode<K, V>? = node?.parent
        val leftChild: RBTreeNode<K, V>? = node?.left

        node?.left = leftChild?.right
        if (leftChild?.right != null) {
            leftChild.right?.parent = node
        }

        leftChild?.right = node
        node?.parent = leftChild

        replaceParentsChild(parent, node, leftChild)
    }

    private fun rotateLeft(node: RBTreeNode<K, V>?) {
        val parent: RBTreeNode<K, V>? = node?.parent
        val rightChild: RBTreeNode<K, V>? = node?.right

        node?.right = rightChild?.left
        if (rightChild?.left != null) {
            rightChild.left?.parent = node
        }

        rightChild?.left = node
        node?.parent = rightChild

        replaceParentsChild(parent, node, rightChild)
    }

    private fun replaceParentsChild(
        parent: RBTreeNode<K, V>?,
        oldChild: RBTreeNode<K, V>?,
        newChild: RBTreeNode<K, V>?,
    ) {
        if (parent == null) {
            root = newChild
        } else if (parent.left === oldChild) {
            parent.left = newChild
        } else if (parent.right === oldChild) {
            parent.right = newChild
        } else {
            throw IllegalStateException("RBTreeNode<K, V> is not a child of its parent")
        }

        if (newChild != null) {
            newChild.parent = parent
        }
    }


}

