import TreeNodes.AVLNode

abstract class BinarySearchTree<T: Comparable<T>, V, U : Node<T,V,U>> {
    abstract var root: U?

    abstract fun insert(key: T)
    //abstract fun insert(node: U)

    abstract fun remove(key: T)
    //abstract fun remove(node: U)

    open fun search(key: T) : U? {
        if (this.root == null) {
            return null
        }

        var curr: U? = root

        while(curr != null) {

            if (curr.key == key) return curr
            if (curr.key > key) {
                curr = curr.left
            } else {
                curr = curr.right
            }
        }

        return null
    }

    //abstract fun search(node: U)


    // We can overload every method
    // If u want, add new insert/remove/search
    // With new argument node: U
}


interface Node<T: Comparable<T>, V, U: Node<T,V,U>> {
    var left: U?
    var right: U?
    var key: T
    var data: V
}