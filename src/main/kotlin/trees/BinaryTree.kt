import treeNodes.BinaryTreeNode
import java.security.InvalidKeyException

abstract class BinaryTree<K : Comparable<K>, V, U : BinaryTreeNode<K, V, U>> {
    protected open var root: U? = null

    abstract fun insert(key: K, data: V)

    abstract fun remove(key: K)

    open fun search(key: K): V? {
        if (this.root == null) {
            throw InvalidKeyException("Empty tree")
        }

        var curr: U? = root

        while (curr != null) {
            if (curr.key == key) return curr.data
            curr = if (curr.key > key) {
                curr.left
            } else {
                curr.right
            }
        }

        throw InvalidKeyException("No such key in the Tree")
    }


    fun getMax(): V? {

        var curr: U = root ?: return null
        while (curr.right != null) {
            curr = curr.right!!
        }

        return curr.data
    }

    fun getMin(): V? {

        var curr: U = root ?: return null
        while (curr.left != null) {
            curr = curr.left!!
        }

        return curr.data
    }

    protected fun getMinNodeFromNode(node: U): U {

        var curr: U = node
        while (curr.left != null) {
            curr = curr.left!!
        }

        return curr
    }

    protected fun isEmpty(): Boolean {
        return when {
            root == null -> true
            else -> false
        }
    }

    // TODO seem's like shitty code
    // TODO DELETE
    open fun traversal(node: U?) {
        if (node == null) return
        traversal(node.left)
        print("${node.key} ")
        traversal(node.right)
    }
}
