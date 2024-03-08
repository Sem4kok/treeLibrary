

abstract class BinaryTree<K : Comparable<K>, V, U : BinaryTreeNode<K, V, U>> {
    abstract var root: U?

    abstract fun insert(key: K, data: V)

    abstract fun remove(key: K)

    open fun search(key: K): V? {
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

        return null
    }
}


abstract class BinaryTreeNode<K: Comparable<K>, V, U> (
    var key: K,
    var data: V
) {
    open var left: U? = null
    open var right: U? = null
}