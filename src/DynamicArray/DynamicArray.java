package DynamicArray;

import java.util.Iterator;

public class DynamicArray<T> implements LinearList<T>, Iterable<T>{
    
    private T[] elements;
    private int capacity;
    private int size;
    
    public DynamicArray(){
        this.size = 0;
        this.capacity = 8;
        this.elements = (T[]) new Object[capacity];
    }
    
    private void CheckIndex(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException("The index is larger than the size");
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("The index is less than zero");
        }
    }
    
    private void resize() {
        T[] newElements = (T[]) new Object[capacity * 2];
        capacity *=2;
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void add(T element) {
        if (size == capacity)
            resize();
        elements[size] = element;
        size++;
    }
    
    @Override
    public T remove(int index) {
        CheckIndex(index);
        T element = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return element;
    }
    
    public boolean RemoveElement(T element) {
        for (int i = 0; i<size; i++) {
            if (elements[i].equals(element)) {
                remove(i);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int indexOf(T theElement) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(theElement)) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public T get(int index) {
        CheckIndex(index);
        return elements[index];
    }
    
    public void Swap(int indexOne, int indexTwo) {
        CheckIndex(indexOne);
        CheckIndex(indexTwo);

        T p = elements[indexOne];
        elements[indexOne] = elements[indexTwo];
        elements[indexTwo] = p;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int index, T x) {
        add(x);
    }
    
    private class ArrayIterator implements Iterator<T>{

        private int position;
        private int size;
        
        public ArrayIterator(){
            this.position = 0;
            this.size = elements.length;
        }
        
        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T element = elements[position];
                position++;
                return element;
            } else {
                return null;
            }
        }
        
    }
    
}
