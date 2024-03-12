
![Logo](https://i.ibb.co/XXyYHQC/Screenshot-11.png)


TreeLibrary is a library of trees needed in development. It provides an excellent interface for interacting with binary trees and is easily extensible for your needs.

Tree Library is being actively developed by SPBU students. The library is currently in beta, as we want to get feedback from users and test a few promising ideas. The library API is quite stable, but we do not exclude that we will make small changes to it.

## Usage

At initialization time, specify the comparable data type as the first parameter, and what you want to store as the second parameter - It can be anything.
```
    val tree1 = BSTree<String, Text>()
    val tree2 = AVLTree<Double, Photo>()
    val tree3 = RBTree<Int, BigInt>()
```
Same keys are NOT ALLOWED. Adding by a key that was already in the tree will not change anything
```
    val tree = RBTree<Int, String>()
    tree.insert(1,"Bulldog")
    tree.insert(1,"English Cocker Spaniel")
    println(tree.search(1)) // Exception in thread "main" IllegalArgumentException: BST already contains a node with key 1
```
First you need to replace the value of the key
```
    val tree = RBTree<Int, String>()
    tree.insert(1,"Bulldog")
    tree.remove(1)
    tree.insert(1,"English Cocker Spaniel")
    println(tree.search(1)) // Bulldog
```
## Authors

- [@suvorovrain](https://github.com/suvorovrain)
- [@dronshock](https://github.com/DronShock)
- [@peso69](https://github.com/Sem4kok)


[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)

