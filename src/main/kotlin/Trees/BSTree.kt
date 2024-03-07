package Trees

import BinarySearchTree
import TreeNodes.BSTNode

class BSTree<T: Comparable<T>, V>: BinarySearchTree<T,V,BSTNode<T, V>>() {
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

}