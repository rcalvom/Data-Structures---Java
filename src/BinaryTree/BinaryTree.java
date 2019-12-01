package BinaryTree;

public class BinaryTree<T> {
    
    protected BinaryTreeNode<T> root;
    
    public BinaryTree(){
        root = null;
    }
    
    public void Insert(T element){
        root = Insert(element,root,0);
    }
    
    public void Remove(T element){
        root = Remove(element,root);
    }
    
    public T FindMin(){
        if(IsEmpty())
            return null;
        return FindMin(root).getElement();
    }
    
    public T FindMax(){
        if(IsEmpty())
            return null;
        return FindMax(root).getElement();
    }
    
    public boolean Contains(T element){
        return Contains(element, root);
    }
    
    public void MakeEmpty(){
        root = null;
    }
    
    public boolean IsEmpty(){
        return root == null;
    }
    
    @Override
    public String toString(){
        String Tree = "[";
        Tree = Tree + toString(root);
        Tree = Tree.substring(0, Tree.length()-2);
        Tree = Tree + "]";
        return Tree;
    }
    
    /*private BinaryTreeNode<T> Insert(T element, BinaryTreeNode<T> node, int Height) {
        if (node == null) {
            return new BinaryTreeNode<>(element, Height);
        } else {
            int compareResult = element.toString().compareTo(node.getElement().toString());
            if (compareResult > 0) {
                node.setRightChild(Insert(element, node.getRightChild(), Height+1));
            } else if (compareResult < 0) {
                node.setLeftChild(Insert(element, node.getLeftChild(), Height+1));
            }
        }
        return node;
    } */
    
    private BinaryTreeNode<T> Insert(T element, BinaryTreeNode<T> node, int Height) {
        if (node == null) {
            return new BinaryTreeNode<>(element, Height);
        } else {
            int compareResult = element.toString().compareTo(node.getElement().toString());
            if (compareResult > 0) {
                node.setRightChild(Insert(element, node.getRightChild(), Height+1));
                if(node.getRightChild().getHeight()-node.getLeftChild().getHeight() == 2){
                    if(node.getRightChild().getElement().toString().compareTo(element.toString())<0){
                        SingleRotationL(node);
                    }else{
                        DoubleRotationLR(node);
                    }
                }
            } else if (compareResult < 0) {
                node.setLeftChild(Insert(element, node.getLeftChild(), Height+1));
                if(node.getLeftChild().getHeight()-node.getRightChild().getHeight() == 2){
                    if(node.getLeftChild().getElement().toString().compareTo(element.toString())>0){
                        SingleRotationR(node);
                    }else{
                        DoubleRotationRL(node);
                    }
                }
            }
        }
        return node;
    } 
    
    private BinaryTreeNode<T> Remove(T element, BinaryTreeNode<T> node) {
        if (node == null)
            return node;
        int compareResult = element.toString().compareTo(node.getElement().toString());
        if (compareResult < 0)
            node.setLeftChild(Remove(element, node.getLeftChild()));
        else if (compareResult > 0)
            node.setRightChild(Remove(element, node.getRightChild()));
        else if (node.getLeftChild() != null && node.getRightChild() != null) {
            node.setElement(FindMin(node.getLeftChild()).getElement());
            node.setRightChild(Remove(node.getElement(), node.getRightChild()));
        } else
            node = (node.getLeftChild() != null) ? node.getLeftChild() : node.getRightChild();
        return node;
    }
    
    private BinaryTreeNode<T> FindMin(BinaryTreeNode<T> node) {
        if (node.getLeftChild() == null)
            return node;
        else
            return FindMin(node.getLeftChild());
    }
    
    private BinaryTreeNode<T> FindMax(BinaryTreeNode<T> node) {
        if (node.getRightChild() == null)
            return node;
        else
            return FindMax(node.getRightChild());
    }
    
    private boolean Contains(T element, BinaryTreeNode<T> node) {
        if (node == null) {
            return false;
        } else {
            int compareResult = element.toString().compareTo(node.getElement().toString());
            if (compareResult > 0) {
                return Contains(element, node.getRightChild());
            } else if (compareResult < 0) {
                return Contains(element, node.getRightChild());
            } else {
                return true;
            }
        }
    }
    
    private String toString(BinaryTreeNode<T> node) {
        String Tree = "";
        if (node.getLeftChild() != null)
            Tree = toString(node.getLeftChild());
        Tree = Tree + node.getElement().toString() + ", ";
        if (node.getRightChild() != null)
            Tree = Tree + toString(node.getRightChild());
        return Tree;
    }
    
    private int Height(BinaryTreeNode<T> node) {
        if (node == null)
            return -1;
        else {
            int leftHeight = Height(node.getLeftChild());
            int rightHeight = Height(node.getRightChild());
            return 1 + ((leftHeight > rightHeight) ? leftHeight : rightHeight);
        }
    }
    
    private void SingleRotationL(BinaryTreeNode<T> node){
        BinaryTreeNode<T> tmp = node.getLeftChild();
        node.setLeftChild(node.getRightChild());
        tmp.setRightChild(node);
    }
    
    private void SingleRotationR(BinaryTreeNode<T> node){
        BinaryTreeNode<T> tmp = node.getRightChild();
        node.setRightChild(node.getLeftChild());
        tmp.setLeftChild(node);
    }
    
    private void DoubleRotationLR(BinaryTreeNode<T> node){
        SingleRotationR(node.getLeftChild());
        SingleRotationL(node);
    }
    
    private void DoubleRotationRL(BinaryTreeNode<T> node){
        SingleRotationL(node.getRightChild());
        SingleRotationR(node);
    }
    
}
