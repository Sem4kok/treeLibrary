package treeNodes
import BinaryTreeNode

enum class Color{
    RED, BLACK
}

open class RBTreeNode<K: Comparable<K>, V>(
    key: K,
    data: V,
    var color: Color = Color.BLACK
): BinaryTreeNode<K, V,RBTreeNode<K, V>>(key,data), WithParent<RBTreeNode<K, V>> {
    override var parent: RBTreeNode<K, V>? = null
}