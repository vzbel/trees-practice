package Node;

public interface BinNode<E> {

    // Get element value
    public E value();

    // Set element value
    public void setValue(E value);

    // Get left or right child
    public BinNode<E> leftChild();

    public BinNode<E> rightChild();

    // Indicate if the node is a leaf
    public boolean isLeaf();
}
