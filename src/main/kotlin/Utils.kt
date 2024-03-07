abstract class BinaryTree<T: Comparable<T>, U> {
    abstract var root: U?

    abstract fun insert(key: T)
    //abstract fun insert(node: U)

    abstract fun remove(key: T)
    //abstract fun remove(node: U)

    abstract fun search(key: T) : U?
    //abstract fun search(node: U)


    // We can overload every method
    // If u want, add new insert/remove/search
    // With new argument node: U
}


abstract class BinaryTreeNode<T: Comparable<T>, V, U> (
    var key: T,
    var data: V
) {
    open var left: U? = null
    open var right: U? = null
}