package trees

import BinaryTree
import treeNodes.RBTreeNode



class RBTree<T: Comparable<T>, V>: BinaryTree<T, V, RBTreeNode<T, V>>() {
    val RED: Boolean = false
    val BLACK: Boolean = true

    override var root: RBTreeNode<T, V>? = null

    override fun insert(key: T) {
        TODO("Write realization of insert")
    }


    override fun remove(key: T) {
        TODO("Write realization of remove")
    }


}