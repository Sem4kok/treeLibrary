package TreeNodes
import BinaryTreeNode

class BSTNode<T: Comparable<T>>(
    data: T
) : BinaryTreeNode<T, BSTNode<T>>(data) {
}