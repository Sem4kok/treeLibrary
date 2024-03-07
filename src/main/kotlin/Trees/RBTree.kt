package Trees

import BinaryTree
import TreeNodes.RBNode


val BLACK = false
val RED = true
class RBTree<T: Comparable<T>>: BinaryTree<T, RBNode<T>>() {
    override var root: RBNode<T>? = null

    override fun insert(value: T) {
        TODO("Write realization of insert")
    }


    /*    override fun insert(node: BSTNode<T>) {
            insert(node.data)
        }
    */


    override fun remove(value: T) {
        TODO("Write realization of remove")
    }


    /*    override fun remove(value: T) {
            TODO("Write realization of remove by node")
        }
    */

    override fun search(value: T) {
        TODO("Write realization of search by node")
    }

    /*
        override fun search(value: T) {
            TODO("Write realization of search by node")
        }
    */

}