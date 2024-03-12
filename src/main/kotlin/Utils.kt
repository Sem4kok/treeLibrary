import java.security.InvalidKeyException
import java.util.concurrent.atomic.AtomicReference


abstract class BinaryTree<K : Comparable<K>, V, U : BinaryTreeNode<K, V, U>> {
    protected open var root: U? = null

    abstract fun insert(key: K, value: V)

    abstract fun remove(key: K)

    open fun search(key: K): V? {
        return searchNode(key).value
    }


    fun getMax() : V? {

        var curr: U = root ?: return null
        while (curr.right != null) {
            curr = curr.right!!
        }

        return curr.data
    }

    fun getMin() : V? {

        var curr: U = root ?: return null
        while (curr.left != null) {
            curr = curr.left!!
        }

        return curr.data
    }

    protected fun getMinNodeFromNode(node: U) : U {

        var curr: U = node
        while (curr.left != null) {
            curr = curr.left!!
        }


    protected fun getMinNodeFromNode(node: U): U {
        var leftChild = node.left
        do {
            if (leftChild != null) {
                val tmpLeftChild = leftChild
                leftChild = leftChild.left
                if (leftChild == null) {
                    return tmpLeftChild
                }
            }
        } while (leftChild != null)
        return node
    }


    protected fun isEmpty(): Boolean {
        return when {
            root == null -> true
            else -> false
        }
    }
    //
    // TODO seem's like shitty code
    // TODO DELETE
    open fun traversal(node: U?) {
        if (node == null) return
        traversal(node.left)
        print("${node.key} ")
        traversal(node.right)
    }
}


abstract class BinaryTreeNode<K : Comparable<K>, V, U>(
    var key: K,
    var value: V
) {
    open var left: U? = null
    open var right: U? = null
}