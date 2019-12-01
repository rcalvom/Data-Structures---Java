package LinkedList;

public interface LinearList<T> {
    
    boolean isEmpty();
    int size();
    T get(int index);
    int indexOf(T x);
    T remove(int index);
    void add(int index, T x);
    String toString();
    
}