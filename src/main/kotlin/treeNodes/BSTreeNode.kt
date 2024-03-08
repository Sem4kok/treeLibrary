package treeNodes
import BinaryTreeNode

class BSTreeNode<T: Comparable<T>, V>(
    key: T,
    data: V
) : BinaryTreeNode<T, V,BSTreeNode<T,V>>(key,data)