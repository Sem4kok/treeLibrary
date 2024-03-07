package TreeNodes

import Node

class AVLNode<T: Comparable<T>, V>(
    override var key: T,
    override var data: V
): Heights, Node<T,V,AVLNode<T,V>> {
    override var height: Int = 0
    override var left: AVLNode<T, V>? = null
    override var right: AVLNode<T, V>? = null

}