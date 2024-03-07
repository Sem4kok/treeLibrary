package TreeNodes
import BinaryTreeNode

class BSTNode<T: Comparable<T>>(
    data: T
) : BinaryTreeNode<T, BSTNode<T>>(data) {
    override var left: BSTNode<T>? = null
    override var right: BSTNode<T>? = null
}