package trees

import BinaryTree
import treeNodes.AVLTreeNode
import java.lang.Exception

class AVLTree<K: Comparable<K>, V>: BinaryTree<K, V, AVLTreeNode<K, V>>() {
    override var root: AVLTreeNode<K, V>? = null

    override fun insert(key: K, data: V) {

        if (root == null) {
            root = AVLTreeNode(key, data)
            return
        }

        var curr: AVLTreeNode<K, V>? = root
        var currParent: AVLTreeNode<K, V>? = root


        while (curr != null) {

            currParent = curr
            if (curr.key > key) {
                curr = curr.left
            } else if (curr.key < key) {
                curr = curr.right
            } else {
                curr.data = data
                return /* nothing to balance after overwriting */
            }
        }

        val node: AVLTreeNode<K, V>
        if (currParent!!.key > key) {
            currParent.left = AVLTreeNode(key, data)
            currParent.height = maxOf(getRightChildHeight(currParent),getLeftChildHeight(currParent)) + 1
            node = currParent.left!!
        } else {
            currParent.right = AVLTreeNode(key, data)
            currParent.height = maxOf(getRightChildHeight(currParent),getLeftChildHeight(currParent)) + 1
            node = currParent.left!!
        }

        return balanceTreeByNode(node)
    }

    private fun balanceFactor(node: AVLTreeNode<K, V>) : Int {
        return (getLeftChildHeight(node.left) - getRightChildHeight(node.right))
    }

    private fun getLeftChildHeight(node: AVLTreeNode<K, V>?) : Int {
        return when {
            node == null -> 0
            else -> node.height
        }
    }
    private fun getRightChildHeight(node: AVLTreeNode<K, V>?) : Int {
        return when {
            node == null -> 0
            else -> node.height
        }
    }

    private fun balanceTreeByNode(node: AVLTreeNode<K, V>) {

    }

    override fun remove(key: K) {
        // TODO: Implement removal logic
    }

}