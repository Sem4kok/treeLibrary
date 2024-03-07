package TreeNodes

import BinaryTreeNode

class AVLNode<T: Comparable<T>, V>(
    key: T,
    data: V
): BinaryTreeNode<T, V,AVLNode<T, V>>(key,data), Heights {
    override var height: Int = 0
}