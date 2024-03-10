package trees

import BinaryTree
import treeNodes.BSTreeNode



class BSTree<K : Comparable<K>, V> : BinaryTree<K, V, BSTreeNode<K, V>>() {
    override var root: BSTreeNode<K, V>? = null

    override fun insert(key: K, value: V) {
        root = insertBST(root, key, value)
    }

    private fun insertBST(node: BSTreeNode<K, V>?, key: K, value: V): BSTreeNode<K, V> {
        var currentNode = node
        if (currentNode == null) {
            currentNode = BSTreeNode(key, value)
            return currentNode
        }

        if (currentNode.key > key) {
            currentNode.left = insertBST(currentNode.left,key, value)
        } else {
            currentNode.right = insertBST(currentNode.left,key, value)
        }
        return currentNode
    }

    //
    override fun remove(key: K) {
        val tmpRoot = root
        if(tmpRoot==null){
            return
        }
        else{
            root = remove(tmpRoot, key)
        }
    }
    //TODO fix this shitt
    private fun remove(node: BSTreeNode<K, V>, key: K): BSTreeNode<K, V> {
        var leftChild = node.left
        var rightChild = node.right
        when {
            key < node.key && leftChild!=null -> node.left = remove(leftChild, key)
            key > node.key && rightChild!=null -> node.right = remove(rightChild, key)
            else -> {
                if (leftChild == null && rightChild!=null) {
                    return rightChild
                } else if (rightChild == null && leftChild!=null) {

                    return leftChild
                }
                if(node.right!=null){
                    node.key = getMinNodeFromNode(node.right).key
                    node.right = remove(rightChild, node.key)
                }
            }
        }

        return node
    }

}
fun main() {
    val tree = BSTree<Int, Int>()
    tree.insert(5, 111)
    tree.insert(2,1)
    tree.remove(2)
    var a = tree.search(2)
}
