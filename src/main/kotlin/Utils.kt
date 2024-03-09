import java.security.InvalidKeyException

abstract class BinaryTree<K : Comparable<K>, V, U : BinaryTreeNode<K, V, U>> {
    protected open var root: U? = null //!

    abstract fun insert(key: K, data: V)

    abstract fun remove(key: K)

    open fun search(key: K): V? {
        if (this.root == null) {
            throw InvalidKeyException("Empty tree")
        }

        var curr: U? = root

        while (curr != null) {
            if (curr.key == key) return curr.value
            curr = if (curr.key > key) {
                curr.left
            } else {
                curr.right
            }
        }


        throw InvalidKeyException("No such key in the Tree")
    }

    // TODO REWRITE MAYBE PRIVATE METHOD
    protected fun searchNodeAndParent(key: K): Pair<U?, U?> /* Pair<Child, Parent> */ {
        if (this.root == null) {
            return Pair(null,null)
        }

        var curr: U? = root
        var currParent: U? = null



        while (curr != null) {
            if (curr.key == key) return Pair(curr, currParent)
            currParent = curr
            curr = if (curr.key > key) {
                curr.left
            } else {
                curr.right
            }
        }

        return Pair(null,null)
    }

        fun getMax() : V? {
            var curr: U = root ?: return null
            while (curr.right != null) {
                curr = curr.right
            }
            return curr.value
        }

        fun getMin() : V {
            var curr: U = root ?: throw Exception("popa")
            while (curr.left != null) {
                curr = curr.let{curr.left}
            }

            return curr.value
        }

        protected fun getMaxNodeFromNode(node: U) : U {

            var curr: U = node
            while (curr.right != null) {
                curr = curr.right  
            }

            return curr
        }
        protected fun getMinNodeFromNode(node: U) : U {

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
        print("${ node.key } ")
        traversal(node.right)
    }
}


abstract class BinaryTreeNode<K: Comparable<K>, V, U> (
    var key: K,
    var value: V
) {
    open var left: U? = null
    open var right: U? = null
}