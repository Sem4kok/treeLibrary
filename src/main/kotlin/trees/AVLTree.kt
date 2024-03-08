package trees

import BinaryTree
import treeNodes.AVLTreeNode
import java.lang.Exception

class AVLTree<K: Comparable<K>, V>: BinaryTree<K, V, AVLTreeNode<K, V>>() {
    override var root: AVLTreeNode<K, V>? = null

    override fun insert(key: K, data: V) {

        if (root == null) {
            root = AVLTreeNode(key,data)
            return
        }


    }

    override fun remove(key: K) {
        // TODO: Implement removal logic
    }

}
