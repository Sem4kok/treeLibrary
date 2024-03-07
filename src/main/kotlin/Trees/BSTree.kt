package Trees

import BinaryTree
import TreeNodes.BSTNode

class BSTree<T: Comparable<T>>: BinaryTree<T,BSTNode<T>>() {
    override var root: BSTNode<T>? = null

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

    override fun search(value: T): BSTNode<T> {
        TODO("Write realization of search by node")
    }

/*
    override fun search(node: T): BSTNode<T> {
        TODO("Write realization of search by node")
    }
*/

}