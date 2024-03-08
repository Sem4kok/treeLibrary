package treeNodes
import BinaryTreeNode


class RBTreeNode<K: Comparable<K>, V>(
    key: K,
    data: V
): BinaryTreeNode<K, V,RBTreeNode<K, V>>(key,data), RedBlack, WithParent<RBTreeNode<K, V>> {
    override var parent: RBTreeNode<K, V>? = null
    override var color: Boolean = false
}