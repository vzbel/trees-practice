package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Node.Node;

public class NodeTest {
    private Node node;
    // These will not be assigned as children instantly,
    // but rather on a use case basis.
    private Node leftChild;
    private Node rightChild;

    // Initialize sample nodes
    public NodeTest() {
        this.node = new Node(1);
        this.leftChild = new Node(0);
        this.rightChild = new Node(3);
    }

    @Test
    // Check the node's predetermined data.
    public void data() {
        assertEquals(1, this.node.data());
    }

    @Test
    // Check if data assignment works.
    public void setData() {
        this.node.setData(11);
        assertEquals(11, this.node.data());
    }

    @Test
    // Verify that the left child is assigned correctly in the default state.
    public void leftChild() {
        assertEquals(null, this.node.leftChild());
    }

    @Test
    // Verify that the left child is assigned correctly after setting it.
    public void setLeftChild() {
        this.node.setLeftChild(this.leftChild);
        assertEquals(this.leftChild, this.node.leftChild());
    }

    @Test
    // Verify that the right child is assigned correctly in the default state.
    public void rightChild() {
        assertEquals(null, this.node.leftChild());
    }

    @Test
    // Verify that the right child is assigned correctly after setting it.
    public void setRightChild() {
        this.node.setRightChild(this.rightChild);
        assertEquals(this.rightChild, this.node.rightChild());
    }
}
