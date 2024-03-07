package Trees

import BinaryTree
import TreeNodes.BSTNode

class BSTree<T: Comparable<T>, V>: BinaryTree<T,BSTNode<T, V>>() {
    override var root: BSTNode<T, V>? = null

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


/*    override fun remove(key: T) {
        TODO("Write realization of remove by node")
    }
*/

    override fun search(key: T): BSTNode<T, V> {
        TODO("Write realization of search by node")
    }

/*
    override fun search(node: T): BSTNode<T> {
        TODO("Write realization of search by node")
    }
*/

}