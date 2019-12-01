package LinkedList;

public class ChainNode<T> {
    public T element;
    public ChainNode<T> next;
    
    public ChainNode(){
        this(null,null);
    }
            
    public ChainNode(T element){
        this(element,null);
    }
    
    public ChainNode(T element, ChainNode<T> next){
        this.element = element;
        this.next = next;
    }
}
