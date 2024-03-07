package Trees

import BinarySearchTree
import TreeNodes.RBNode


val BLACK = false
val RED = true
class RBTree<T: Comparable<T>, V>: BinarySearchTree<T, V, RBNode<T, V>>() {
    override var root: RBNode<T, V>? = null

    override fun insert(key: T) {
        TODO("Write realization of insert")
    }


    /*    override fun insert(node: BSTNode<T>) {
            insert(node.data)
        }
    */


    override fun remove(key: T) {
        TODO("Write realization of remove")
    }


    /*    override fun remove(value: T) {
            TODO("Write realization of remove by node")
        }
    */
}