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

    public int size() {
        return this.nodeCount;
    }

    public void print() {
        printHelp(this.root);
    }

    public void printHelp(BSTNode<E> root) {
        // If reached null, print nothing.
        if (root == null) {
            return;
        }
        // Visit the left subtree
        printHelp(root.leftChild());
        // Visit node
        System.out.print(root.value() + " ");
        // Visit the right subtree
        printHelp(root.rightChild());
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

    // Get the maximum value in the tree.
    public BSTNode<E> getMax(BSTNode<E> root) {
        // Reach the maximum value.
        if (root.rightChild() == null) {
            return root;
        }
        // Proceed right towards larger values.
        return getMax(root.rightChild());
    }

    // Remove a record from the tree.
    // Return the value removed from the tree.
    public E remove(E key) {
        // First find the value
        E temp = find(key);
        // Proceed if the value isn't null
        if (temp != null) {
            // Remove the node
            this.root = removeHelp(this.root, key);
            this.nodeCount--;
        }
        return temp;
    }

    public BSTNode<E> removeHelp(BSTNode<E> root, E key) {
        // Empty subtree
        if (root == null) {
            return null;
        } else if (root.value().compareTo(key) > 0) {
            // Move to left subtree
            root.setLeftChild(removeHelp(root.leftChild(), key));
        } else if (root.value().compareTo(key) < 0) {
            // Move to right subtree
            root.setRightChild(removeHelp(root.rightChild(), key));
        } else {
            // Found the node. We must find the heir.
            // First, either it has no left child or no children at all.
            if (root.leftChild() == null) {
                return root.rightChild();
            } else if (root.rightChild() == null) { // Or, it has no right child.
                return root.leftChild();
            } else { // Otherwise, it has two children.
                // Get the largest node in the left subtree.
                BSTNode<E> temp = getMax(root.leftChild());
                // Replace the removed node's value with temp.
                root.setValue(temp.value());
                // Remove the temp value from the left subtree.
                // Adjust the root's left child accordingly.
                root.setLeftChild(deleteMaxHelp(root.leftChild()));
            }
        }
        // Return the root
        return root;
    }
}
