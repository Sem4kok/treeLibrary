package treeNodes

class BSTreeNode<K : Comparable<K>, V>(
    key: K,
    data: V,
) : BinaryTreeNode<K, V, BSTreeNode<K, V>>(key, data)