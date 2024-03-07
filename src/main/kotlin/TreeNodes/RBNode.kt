package TreeNodes
import BinaryTreeNode


class RBNode<T: Comparable<T>, V>(
    key: T,
    data: V
): BinaryTreeNode<T, V,RBNode<T, V>>(key,data), RedBlack, WithParent<RBNode<T, V>> {
    override var parent: RBNode<T, V>? = null
    override var color: Boolean = false
}