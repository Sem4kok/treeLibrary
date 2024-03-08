package trees

import BinaryTree
import treeNodes.AVLTreeNode
import treeNodes.BSTreeNode

class BSTree<K: Comparable<K>, V>: BinaryTree<K, V, BSTreeNode<K, V>>() {
    override var root: BSTreeNode<K, V>? = null

    override fun insert(key: K, data: V) {
        TODO("Write realization of insert")
    }

    override fun remove(key: K) {
        TODO("Write realization of remove")
    }

}
