package TreeNodes

import BinaryTreeNode

class AVLNode<T: Comparable<T>>(
    data: T
): BinaryTreeNode<T, AVLNode<T>>(data), Heights {
    override var height: Int = 0
}