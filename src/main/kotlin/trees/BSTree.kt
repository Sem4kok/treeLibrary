package trees

import BinaryTree
import treeNodes.AVLTreeNode
import treeNodes.BSTreeNode

class BSTree<T: Comparable<T>, V>: BinaryTree<T, V, BSTreeNode<T, V>>() {
    override var root: BSTreeNode<T, V>? = null

    override fun insert(key: T) {
        TODO("Write realization of insert")
    }

    override fun remove(key: T) {
        TODO("Write realization of remove")
    }

}