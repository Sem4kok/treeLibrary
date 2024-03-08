

abstract class BinaryTree<T : Comparable<T>, V, U : BinaryTreeNode<T, V, U>> {
    abstract var root: U?

    abstract fun insert(key: T)

    abstract fun remove(key: T)

    open fun search(key: T): V? {
        if (this.root == null) {
            return null
        }

        var curr: U? = root

        while (curr != null) {
            if (curr.key == key) return curr.data
            curr = if (curr.key > key) {
                curr.left
            } else {
                curr.right
            }
        }

        throw NoSuchElementException("Element not found")
    }
}


abstract class BinaryTreeNode<T: Comparable<T>, V, U> (
    var key: T,
    var data: V
) {
    open var left: U? = null
    open var right: U? = null
}