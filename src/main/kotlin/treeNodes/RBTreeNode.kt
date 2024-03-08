package treeNodes
import BinaryTreeNode


class RBTreeNode<T: Comparable<T>, V>(
    key: T,
    data: V
): BinaryTreeNode<T, V,RBTreeNode<T, V>>(key,data), RedBlack, WithParent<RBTreeNode<T, V>> {
    override var parent: RBTreeNode<T, V>? = null
    override var color: Boolean = false
}