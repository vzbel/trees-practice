// This is an implementation of the Binary Search Tree's traversal functions.
// The class is currently unusuable and only serves as a placeholder for these functions.

package BinarySearchTree;

import Node.Node;

public class BinarySearchTree {

    // Default constructor
    public BinarySearchTree() {
    }

    // Enumerate the tree using preorder traversal.
    public void preorderTraversal(Node root) {
        // Empty subtree, do nothing but return
        if (root == null) {
            return;
        }
        // Visit node
        System.out.println(root.data());
        // Visit left subtree
        preorderTraversal(root.leftChild());
        // Visit right subtree
        preorderTraversal(root.rightChild());
    }

    // Enumerate the tree using postorder traversal.
    public void postorderTraversal(Node root) {
        // Empty subtree, do nothing but return
        if (root == null) {
            return;
        }
        // Visit left subtree
        postorderTraversal(root.leftChild());
        // Visit right subtree
        postorderTraversal(root.rightChild());
        // Visit node
        System.out.println(root.data());
    }

    // Enumerate the tree using inorder traversal.
    public void inorderTraversal(Node root) {
        // Empty subtree, do nothing but return
        if (root == null) {
            return;
        }
        // Visit the left subtree
        inorderTraversal(root.leftChild());
        // Visit node
        System.out.println(root.data());
        // Visit the right subtree
        inorderTraversal(root.rightChild());
    }
}
