// A class that uses JUnit to test the BSTNode class.
package Tests;

// JUnit imports
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

// Import BSTNode
import Node.BSTNode;

public class BSTNodeTest<E> {
    private BSTNode<Integer> node; // Sample node, use as necessary.
    private BSTNode<Integer> leftChild; // Sample left child node, use as necessary.
    private BSTNode<Integer> rightChild; // Sample right child node, use as necessary.

    public BSTNodeTest() {
        this.node = new BSTNode<>(4);
        this.leftChild = new BSTNode<>(10);
        this.rightChild = new BSTNode<>(20);
    }

    @Test
    public void getValue() {
        assertEquals(Integer.valueOf(4), this.node.value());
    }

    @Test
    public void setValue() {
        this.node.setValue(20);
        assertEquals(Integer.valueOf(20), this.node.value());
    }

    @Test
    public void setLeftChild() {
        // Assign sample left child to node.
        this.node.setLeftChild(this.leftChild);
        // Assert that the left child we created is truly the left child.
        assertEquals(this.leftChild, this.node.leftChild());
    }

    @Test
    public void setRightChild() {
        // Assign sample right child to node.
        this.node.setRightChild(this.rightChild);
        // Assert that the right child we created is truly the right child.
        assertEquals(this.rightChild, this.node.rightChild());
    }

    @Test
    public void getLeftChild() {
        assertEquals(null, this.node.leftChild());
    }

    @Test
    public void getRightChild() {
        assertEquals(null, this.node.rightChild());
    }

    @Test
    public void isLeaf() {
        assertEquals(true, this.node.isLeaf());
    }
}
