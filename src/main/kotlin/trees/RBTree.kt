package trees

import BinaryTree
import treeNodes.RBTreeNode



class RBTree<K: Comparable<K>, V>: BinaryTree<K, V, RBTreeNode<K, V>>() {
    val RED: Boolean = false
    val BLACK: Boolean = true

    override var root: RBTreeNode<K, V>? = null

    override fun insert(key: K, data: V) {
        TODO("Write realization of insert")
    }


    override fun remove(key: K) {
        TODO("Write realization of remove")
    }


}