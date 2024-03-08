package treeNodes

import BinaryTreeNode

class AVLTreeNode<K: Comparable<K>, V>(
    key: K,
    data: V
): BinaryTreeNode<K, V,AVLTreeNode<K, V>>(key,data), Heights {
    override var height: Int = 1
}