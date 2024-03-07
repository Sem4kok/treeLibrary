package TreeNodes
import Node

class BSTNode<T: Comparable<T>, V>(
    override var key: T,
    override var data: V
) : Node<T,V,BSTNode<T,V>> {
    override var left: BSTNode<T, V>? = null
    override var right: BSTNode<T, V>? = null
}