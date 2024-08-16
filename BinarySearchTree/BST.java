// This class is an implementation of the Binary Search Tree.
// Records must be comparable.
package BinarySearchTree;

import Node.BSTNode;

public class BST<E extends Comparable<E>> {
    private BSTNode<E> root; // Root node
    private int nodeCount; // Number of nodes in the BST

    // Constructor
    public BST() {
        this.root = null;
        this.nodeCount = 0;
    }

    // Re-initialize Tree
    public void clear() {
        this.root = null;
        this.nodeCount = 0;
    }

    // Insert a record into the tree.
    public void insert(E key) {
        this.root = this.insertHelp(this.root, key);
        this.nodeCount++;
    }

    public BSTNode<E> insertHelp(BSTNode<E> root, E key) {
        // If the root is null, simply create a new node with the given key.
        if (root == null) {
            return new BSTNode<E>(key);
        }

        // If they argument key value is less than or equal to the root's key value,
        // it belongs in the left subtree of the root. (By definition of BST)
        if (root.value().compareTo(key) >= 0) {
            // Move down the left subtree and repeat the process recursively.
            root.setLeftChild(insertHelp(root.leftChild(), key));
        } else {
            // Else, move down the right subtree since the argument key
            // value is greater than the root's key value.
            root.setRightChild(insertHelp(root.rightChild(), key));
        }

        return root;
    }

    // Search for a given key
    public E find(E key) {
        return findHelp(this.root, key);
    }

    public E findHelp(BSTNode<E> root, E key) {
        // Key not found
        if (root == null) {
            return null;
        }
        if (root.value().compareTo(key) > 0) {
            // If the key is less than the root value, we proceed left.
            return findHelp(root.leftChild(), key);
        } else if (root.value().compareTo(key) == 0) {
            // Key found
            return root.value();
        } else {
            // If the key is greater than the root value, we proceed right.
            return findHelp(root.rightChild(), key);
        }
    }

    public void deleteMax() {
        this.root = deleteMaxHelp(this.root);
        this.nodeCount--;
    }

    // Delete the maximum value in the tree.
    public BSTNode<E> deleteMaxHelp(BSTNode<E> root) {
        // If the root has no right children, it is the max.
        if (root.rightChild() == null) {
            return root.leftChild();
        }
        // Otherwise proceed right.
        root.setRightChild(deleteMaxHelp(root.rightChild()));
        // If a root node isn't the max node, then return the root.
        return root;
    }

}
