// An implementation of the abstract Binary Node interface.
// Contains generic data and a maximum of two children.

package Node;

public class BSTNode<E> implements BinNode<E> {
    private E data; // Generic node data
    private BSTNode<E> leftChild; // Left child
    private BSTNode<E> rightChild; // Right Child

    // Create a new binary search tree node
    public BSTNode(E data) {
        this.data = data; // Assign generic data to object property.
    }

    // Return node data
    public E value() {
        return this.data;
    }

    // Set node data
    public void setValue(E value) {
        this.data = value;
    }

    // Set left child
    public void setLeftChild(BSTNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    // Set right child
    public void setRightChild(BSTNode<E> rightChild) {
        this.rightChild = rightChild;
    }

    // Get left child
    public BSTNode<E> leftChild() {
        return this.leftChild;
    }

    // Get right child
    public BSTNode<E> rightChild() {
        return this.rightChild;
    }

    // Indicate if the node is a leaf
    public boolean isLeaf() {
        return (this.leftChild == null) && (this.rightChild == null);
    }
}