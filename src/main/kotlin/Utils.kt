import java.security.InvalidKeyException
import java.util.concurrent.atomic.AtomicReference


abstract class BinaryTree<K : Comparable<K>, V, U : BinaryTreeNode<K, V, U>> {
    protected open var root: U? = null //!

    abstract fun insert(key: K, value: V)

    abstract fun remove(key: K)

    open fun search(key: K): V? {
        return searchNode(key).value
    }

    protected fun searchNode(key: K): U {
        if (this.root == null) {
            throw InvalidKeyException("Empty tree")
        }
        var curr: U? = root
        while (curr != null && curr.key != key) {
            curr = if (curr.key > key) {
                curr.left
            } else {
                curr.right
            }
        }
        if (curr == null) {
            throw InvalidKeyException("No such key in the Tree")
        }
        return curr
    }

    // TODO REWRITE MAYBE PRIVATE METHOD

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