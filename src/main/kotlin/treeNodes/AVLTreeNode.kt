package treeNodes

import BinaryTreeNode

class AVLTreeNode<T: Comparable<T>, V>(
    key: T,
    data: V
): BinaryTreeNode<T, V,AVLTreeNode<T, V>>(key,data), Heights {
    override var height: Int = 0
}