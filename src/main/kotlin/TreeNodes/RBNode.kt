package TreeNodes
import Node

class RBNode<T: Comparable<T>, V>(
    override var key: T,
    override var data: V
):  RedBlack, WithParent<RBNode<T, V>>, Node<T,V,RBNode<T,V>> {
    override var parent: RBNode<T, V>? = null
    override var color: Boolean = false
    override var left: RBNode<T, V>? = null
    override var right: RBNode<T, V>? = null

}