package Trees

import BinaryTree
import TreeNodes.AVLNode
import java.lang.Exception

class AVLTree<T: Comparable<T>, V>: BinaryTree<T, AVLNode<T, V>>() {
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

    override fun search(key: T): AVLNode<T, V>?  {

        if (this.root == null) {
            return null
        }

        var curr: AVLNode<T, V>? = root

        while(curr != null) {

            if (curr.key == key) return curr
            if (curr.key > key) {
                curr = curr.left
            } else {
                curr = curr.right
            }
        }

        throw NoSuchElementException("Element not found")
    }


    /*
        override fun search(key: T) {
            TODO("Write realization of search by node")
        }
    */
}