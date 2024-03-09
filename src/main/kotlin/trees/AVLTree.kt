package trees

import BinaryTree
import treeNodes.AVLTreeNode


class AVLTree<K : Comparable<K>, V> : BinaryTree<K, V, AVLTreeNode<K, V>>() {
    override var root: AVLTreeNode<K, V>? = null

    override fun insert(key: K, data: V) {
        root = insert(root, key, data)

    }

    override fun remove(key: K) {

        val root = this.root ?: return

        val (target, targetParent) = searchNodeAndParent(key)
        if (target == null) {
            return
        }

        // TODO BALANCE TREE
        if (isChildless(target)) {

            when {
                targetParent == null -> return
                isLeftChild(target, targetParent) -> {

                    targetParent.left = null
                    //updateHeight(targetParent)
                    // TODO balanceTree()
                }

                else -> {

                    targetParent.right = null
                    //updateHeight(targetParent)
                    //TODO balanceTree()
                }
            }
            return
        } else if (target.right == null) {

            // TODO delete comment
            //val leftChild = target.left ?: return
            when {
                targetParent == null -> {
                    this.root = target.left
                    return
                }

                isLeftChild(target, targetParent) -> {

                    targetParent.left = target.left
                    //updateHeight(targetParent)
                    // TODO balanceTree()
                }

                else -> {

                    targetParent.right = target.left
                    //updateHeight(targetParent)
                    //TODO balanceTree()
                }
            }
            return
        } else if (target.left == null) {

            when {
                targetParent == null -> {
                    this.root = target.right
                    return
                }

                isLeftChild(target, targetParent) -> {

                    targetParent.left = target.right
                    //updateHeight(targetParent)
                    // TODO balanceTree()
                }

                else -> {

                    targetParent.right = target.right
                    //updateHeight(targetParent)
                    //TODO balanceTree()
                }
            }
            return

        }


    }


    private fun insert(startNode: AVLTreeNode<K, V>?, key: K, data: V): AVLTreeNode<K, V> {

        var node = startNode
        if (node == null) {
            node = AVLTreeNode(key, data)
            return node
        }

        if (node.key > key) {
            node.left = insert(node.left, key, data)
        } else if (node.key < key) {
            node.right = insert(node.right, key, data)
        }

        updateHeight(node)
        return rotate(node)
    }

    private fun rightRotate(node: AVLTreeNode<K, V>): AVLTreeNode<K, V> {

        val parent = node.left ?: return node

        node.left = parent.right
        parent.right = node

        updateHeight(node)
        updateHeight(parent)

        return parent
    }


    private fun leftRotate(node: AVLTreeNode<K, V>): AVLTreeNode<K, V> {

        val parent = node.right ?: return node

        node.right = parent.left
        parent.left = node

        updateHeight(node)
        updateHeight(parent)

        return parent
    }

    private fun rotate(node: AVLTreeNode<K, V>): AVLTreeNode<K, V> {

        if (getHeight(node.left) - getHeight(node.right) > 1) {

            val leftChild = node.left
            if (leftChild != null) {
                if (getHeight(leftChild.left) - getHeight(leftChild.right) > 0) {
                    return rightRotate(node)
                }

                if (getHeight(leftChild.left) - getHeight(leftChild.right) < 0) {
                    node.left = leftRotate(leftChild)
                    return rightRotate(node)
                }
            }
        }

        if (getHeight(node.left) - getHeight(node.right) < -1) {

            val rightChild = node.right
            if (rightChild != null) {
                if (getHeight(rightChild.left) - getHeight(rightChild.right) < 0) {
                    return leftRotate(node)
                }

                if (getHeight(rightChild.left) - getHeight(rightChild.right) > 0) {
                    node.right = rightRotate(rightChild)
                    return leftRotate(node)
                }
            }
        }

        return node
    }

    private fun updateHeight(node: AVLTreeNode<K, V>?) {
        when {
            node == null -> return
            else -> node.height = 1 + maxOf(getHeight(node.left), getHeight(node.right))
        }
    }

    private fun getHeight(node: AVLTreeNode<K, V>?): Int {
        return node?.height ?: 0
    }

    private fun isChildless(node: AVLTreeNode<K, V>): Boolean {
        return when {
            node.left == null && node.right == null -> true
            else -> false
        }
    }


    // TODO REWRITE EXCEPTION
    private fun isLeftChild(
        child: AVLTreeNode<K, V>,
        parent: AVLTreeNode<K, V>
    ): Boolean {
        return when {
            parent.left == child -> true
            parent.right == child -> false
            else -> throw Exception("Parent hasn't this child")
        }
    }
}


fun main() {
    val tree = AVLTree<Int, Int>()
    tree.insert(5, 111)
    tree.insert(2, 222)
    tree.insert(1, 444)
    tree.insert(12, 555)
    tree.insert(2, 333)
    tree.insert(6, 555)

}