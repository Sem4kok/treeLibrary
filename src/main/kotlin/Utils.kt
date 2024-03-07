abstract class BinaryTree<T: Comparable<T>, U> {
    abstract var root: U?

    abstract fun insert(value: T)
    //abstract fun insert(node: U)

    abstract fun remove(value: T)
    //abstract fun remove(node: U)

    abstract fun search(value: T) : U?
    //abstract fun search(node: U)


    // We can overload every method
    // If u want, add new insert/remove/search
    // With new argument node: U
}


open class BinaryTreeNode<T: Comparable<T>, U> (
    var data: T
) {
    var left: U? = null
    var right: U? = null
}