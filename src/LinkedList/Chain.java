package LinkedList;

import java.util.*;

public class Chain<T> implements LinearList<T>, Iterable<T> {

    protected ChainNode<T> firstNode;
    protected int size;

    public Chain() {
        firstNode = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public int size(){
        return size;
    }
    
    void checkIndex(int index){
        if (index <0 || index > size) throw new IndexOutOfBoundsException("Index = " + index + "  size = " + size);
    }
    
    @Override
    public T get(int index){
        checkIndex(index);
        
        ChainNode<T> currentNode = firstNode;
        for(int i = 0; i<index; i++){
            currentNode = currentNode.next;
        }
        
        return currentNode.element;
    }
    
    @Override
    public int indexOf(T theElement){
        ChainNode<T> currentNode = firstNode;
        int index = 0;
        while(currentNode != null && !currentNode.element.equals(theElement)){
            currentNode = currentNode.next;
            index++;
        }
        if (currentNode == null)
            return -1;
        else 
            return index;
    }
    
    @Override
    public T remove(int index){
        checkIndex(index);
        
        T removedElement;
        if (index == 0){
            removedElement = firstNode.element;
            firstNode = firstNode.next;
        } else {
            ChainNode<T> q = firstNode;
            for(int i = 0; i<index -1; i++)
                q = q.next;
            
            removedElement = q.next.element;
            q.next = q.next.next;
        }
        size--;
        return removedElement;
    }
    
    @Override
    public void add(int index, T theElement){
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index = " + index + " Size = " + size);
        
        if ( index == 0 ) 
            firstNode = new ChainNode<>( theElement, firstNode);
        else {
            ChainNode<T> p = firstNode;
            for(int i = 0; i<index-1; i++)
                p = p.next;
            
            p.next = new ChainNode<>( theElement, p.next);
        }
        size++;
        
    }
    
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("[");
        
        for( T x: this)
            s.append(Objects.toString(x) + ", ");
        
        if (size > 0){
            s.setLength( s.length()-2);
        }
        
        s.append("]");
        
        return new String(s);
    }
    
    @Override
    public Iterator<T> iterator(){
        return new ChainIterator();
    }
    
    private class ChainIterator implements Iterator<T>{
        private ChainNode<T> nextNode;
    
        public ChainIterator(){
            this.nextNode = firstNode;
        }

        @Override
        public boolean hasNext(){
            return nextNode != null;
        }

        @Override
        public T next(){
            if(nextNode != null){
                T elementToReturn = nextNode.element;
                nextNode = nextNode.next;
                return elementToReturn;
            }else{
                throw new NoSuchElementException("No next element");
            }

        }
        
        @Override
        public void remove(){
            throw new UnsupportedOperationException("Remove not supported");
        }
    }
}
