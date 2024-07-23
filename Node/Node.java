package Node;

// A tree node with data and two children.
public class Node {
    private int data;
    private Node leftChild;
    private Node rightChild;

    public Node(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public int data() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node leftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node rightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

}
