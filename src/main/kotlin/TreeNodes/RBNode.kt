package TreeNodes
import BinaryTreeNode


class RBNode<T: Comparable<T>>(
    data: T
): BinaryTreeNode<T, RBNode<T>>(data), RedBlack, WithParent<RBNode<T>> {
    override var left: RBNode<T>? = null
    override var right: RBNode<T>? = null
    override var parent: RBNode<T>? = null
    override var color: Boolean = false
}