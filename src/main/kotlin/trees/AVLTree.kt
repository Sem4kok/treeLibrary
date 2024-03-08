package trees

import BinaryTree
import treeNodes.AVLTreeNode
import java.lang.Exception

class AVLTree<T: Comparable<T>, V>: BinaryTree<T, V, AVLTreeNode<T, V>>() {
    override var root: AVLTreeNode<T, V>? = null

    override fun insert(key: T) {
        // TODO: Implement insertion logic
    }

    override fun remove(key: T) {
        // TODO: Implement removal logic
    }

}
