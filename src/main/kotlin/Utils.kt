abstract class BinaryTree<T: Comparable<T>, U> {
    abstract var root: U?

    abstract fun insert(value: T)
    //abstract fun insert(node: U)

    abstract fun remove(value: T)
    //abstract fun remove(node: U)

    abstract fun search(value: T)
    //abstract fun search(node: U)


    // We can overload every method
    // If u want, add new insert/remove/search
    // With new argument node: U
}


abstract class BinaryTreeNode<T: Comparable<T>, U> (
    var data: T
) {
    abstract var left: U?
    abstract var right: U?
}