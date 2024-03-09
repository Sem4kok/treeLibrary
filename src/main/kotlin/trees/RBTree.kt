package trees

import BinaryTree
import treeNodes.RBTreeNode
class RBTree<K: Comparable<K>, V>: BinaryTree<K, V, RBTreeNode<K, V>>() {
    private val RED: Boolean = true
    private val BLACK: Boolean = false

    private val TNULL: RBTreeNode<K, V>? = null
    init {
        TNULL?.color = BLACK
        TNULL?.left = null
        TNULL?.right = null
    }
    override var root = TNULL
    private fun searchTreeHelper(node: RBTreeNode<K, V>?, key: K): RBTreeNode<K, V>? {
        if (node === TNULL || key == node?.key) {
            return node
        }

        if (key < node.key) {
            return searchTreeHelper(node.left, key)
        }
        return searchTreeHelper(node.right, key)
    }

    // Balance the tree after deletion of a node
    private fun fixDelete(x: RBTreeNode<K, V>?) {
        var x = x
        var s: RBTreeNode<K, V>?
        while (x !== root && x?.color == BLACK) {
            if (x === x.parent?.left) {
                s = x.parent?.right
                if (s?.color == RED) {
                    s.color = BLACK
                    x.parent?.color = RED
                    leftRotate(x.parent)
                    s = x.parent?.right
                }

                if (s?.left?.color == BLACK && s.right?.color == BLACK) {
                    s.color = RED
                    x = x.parent
                } else {
                    if (s?.right?.color == BLACK) {
                        s.left?.color = BLACK
                        s.color = RED
                        rightRotate(s)
                        s = x.parent?.right
                    }

                    s?.color = x.parent?.color
                    x.parent?.color = BLACK
                    s?.right?.color = BLACK
                    leftRotate(x.parent)
                    x = root
                }
            } else {
                s = x.parent?.left
                if (s?.color == RED) {
                    s.color = BLACK
                    x.parent?.color = RED
                    rightRotate(x.parent)
                    s = x.parent?.left
                }

                if (s?.right?.color == BLACK && s.right?.color == BLACK) {
                    s.color = RED
                    x = x.parent
                } else {
                    if (s.left?.color == BLACK) {
                        s.right?.color = BLACK
                        s.color = RED
                        leftRotate(s)
                        s = x.parent?.left
                    }

                    s?.color = x.parent?.color
                    x.parent?.color = BLACK
                    s.left?.color = BLACK
                    rightRotate(x.parent)
                    x = root
                }
            }
        }
        x?.color = BLACK
    }

    private fun rbTransplant(u: RBTreeNode<K, V>?, v: RBTreeNode<K, V>?) {
        if (u?.parent == null) {
            root = v
        } else if (u === u.parent?.left) {
            u.parent?.left = v
        } else {
            u.parent?.right = v
        }
        v?.parent = u?.parent
    }

    private fun deleteNodeHelper(node: RBTreeNode<K, V>?, key: K) {
        var node = node
        var z: RBTreeNode<K, V>? = TNULL
        val x: RBTreeNode<K, V>?
        var y: RBTreeNode<K, V>?
        while (node !== TNULL) {
            if (node?.key == key) {
                z = node
            }

            node = if (node.key <= key) {
                node.right
            } else {
                node.left
            }
        }

        if (z === TNULL) {
            println("Couldn't find key in the tree")
            return
        }

        y = z
        var yOriginalColor = y?.color
        if (z?.left === TNULL) {
            x = z?.right
            rbTransplant(z, z.right)
        } else if (z?.right === TNULL) {
            x = z?.left
            rbTransplant(z, z.left)
        } else {
            y = getMinNodeFromNode(z?.right)
            yOriginalColor = y?.color
            x = y.right
            if (y.parent === z) {
                x?.parent = y
            } else {
                rbTransplant(y, y.right)
                y.right = z.right
                y.right?.parent = y
            }

            rbTransplant(z, y)
            y.left = z.left
            y.left?.parent = y
            y.color = z.color
        }
        if (yOriginalColor == BLACK) {
            fixDelete(x)
        }
    }

    // Balance the node after insertion
    private fun fixInsert(k: RBTreeNode<K, V>) {
        var k: RBTreeNode<K, V>? = k
        var u: RBTreeNode<K, V>?
        while (k?.parent?.color == RED) {
            if (k.parent === k.parent?.parent?.right) {
                u = k.parent?.parent?.left
                if (u?.color == RED) {
                    u.color = BLACK
                    k.parent?.color = BLACK
                    k.parent?.parent?.color = RED
                    k = k.parent?.parent
                } else {
                    if (k === k.parent?.left) {
                        k = k.parent
                        rightRotate(k)
                    }
                    k?.parent?.color = BLACK
                    k.parent?.parent?.color = RED
                    leftRotate(k.parent?.parent)
                }
            } else {
                u = k.parent?.parent?.right

                if (u?.color == RED) {
                    u.color = BLACK
                    k.parent?.color = BLACK
                    k.parent?.parent?.color = RED
                    k = k.parent?.parent
                } else {
                    if (k === k.parent?.right) {
                        k = k.parent
                        leftRotate(k)
                    }
                    k?.parent?.color = BLACK
                    k.parent?.parent?.color = RED
                    rightRotate(k.parent?.parent)
                }
            }
            if (k === root) {
                break
            }
        }
        root?.color = BLACK
    }

    fun searchTree(k: K): RBTreeNode<K, V>? {

        return searchTreeHelper(this.root, k)
    }

    fun successor(x: RBTreeNode<K, V>?): RBTreeNode<K, V>? {
        var x = x
        if (x?.right !== TNULL) {
            return getMinNodeFromNode(x?.right)
        }

        var y = x?.parent
        while (y !== TNULL && x === y?.right) {
            x = y
            y = y?.parent
        }
        return y
    }

    fun predecessor(x: RBTreeNode<K, V>?): RBTreeNode<K, V>? {
        var x = x
        if (x?.left !== TNULL) {
            return getMaxNodeFromNode(x.left)
        }

        var y = x?.parent
        while (y !== TNULL && x === y?.left) {
            x = y
            y = y?.parent
        }

        return y
    }*/

    fun leftRotate(x: RBTreeNode<K, V>?) {
        val y = x?.right
        x.right = y?.left
        if (y.left !== TNULL) {
            y.left?.parent = x
        }
        y.parent = x.parent
        if (x.parent == null) {
            this.root = y
        } else if (x === x.parent?.left) {
            x.parent?.left = y
        } else {
            x.parent?.right = y
        }
        y.left = x
        x.parent = y
    }

    fun rightRotate(x: RBTreeNode<K, V>?) {
        val y = x?.left
        x.left = y?.right
        if (y.right !== TNULL) {
            y.right?.parent = x
        }
        y.parent = x.parent
        if (x.parent == null) {
            this.root = y
        } else if (x === x.parent?.right) {
            x.parent?.right = y
        } else {
            x.parent?.left = y
        }
        y.right = x
        x.parent = y
    }

    override fun insert(key: K, data: V) {
        val node = RBTreeNode<K, V>(key,data)
        node.parent = null
        node.key = key
        node.left = TNULL
        node.right = TNULL
        node.color = RED

        var y: RBTreeNode<K, V>? = null
        var x = this.root

        while (x !== TNULL) {
            y = x
            x = if (node.key < x?.key) {
                x.left
            } else {
                x.right
            }
        }

        node.parent = y
        if (y == null) {
            root = node
        } else if (node.key < y.key) {
            y.left = node
        } else {
            y.right = node
        }

        if (node.parent == null) {
            node.color = BLACK
            return
        }

        if (node.parent?.parent == null) {
            return
        }

        fixInsert(node)
    }

    override fun remove(key: K) {
        deleteNodeHelper(this.root, key)
    }

}

