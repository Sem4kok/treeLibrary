package TreeNodes
import BinaryTreeNode

class BSTNode<T: Comparable<T>, V>(
    key: T,
    data: V
) : BinaryTreeNode<T, V,BSTNode<T,V>>(key,data) {
}