package Trees

import BinarySearchTree
import TreeNodes.AVLNode
import java.lang.Exception

class AVLTree<T: Comparable<T>, V>: BinarySearchTree<T,V,AVLNode<T, V>>() {
    override var root: AVLNode<T, V>? = null


    override fun insert(key: T) {
        TODO("Write realization of insert")
    }


    /*    override fun insert(node: AVLNode<T>) {
            insert(node.data)
        }
    */


    override fun remove(key: T) {
        TODO("Write realization of remove")
    }


    /*    override fun remove(key: T) {
            TODO("Write realization of remove by node")
        }
    */

}