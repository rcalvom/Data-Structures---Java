package BinaryTree;

public class BinaryTreeNode<T> {
    private T element;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;
    private int height;
    
    public BinaryTreeNode(T element, int heigh){
        this.element = element;
        this.height = height;
        leftChild = rightChild = null;
    }
    
    public BinaryTreeNode(T element, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild, int height){
        this.element = element;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.height = height;
    }
    
    @Override
    public String toString(){
        return element.toString();
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
}
