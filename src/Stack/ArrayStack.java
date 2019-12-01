package Stack;

import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {
    int top;
    T[] stack;
    
    public ArrayStack(int initialCapacity){
        if(initialCapacity < 1)
            throw new IllegalArgumentException("initialCapacity must be >= 1");
        stack = (T[])new Object[initialCapacity];
        top = -1;
    }
    
    public ArrayStack(){
        this(10);
    }
    
    @Override
    public boolean isEmpty(){
        return top == -1;
    }
    
    @Override
    public T peek(){
        if(isEmpty())
            throw new EmptyStackException();
        return stack[top];
    }
    
    @Override
    public void push(T theElement){
        if (top == stack.length-1){
            T[] old = stack;
            stack = (T[]) new Object[2*stack.length];
            System.arraycopy(old, 0, stack, 0, old.length);
        }
        
        stack[++top] = theElement;
    }
    
    @Override
    public T pop(){
        if(isEmpty())
            throw  new EmptyStackException();
        T topElement = stack[top];
        stack[top--] = null;
        return topElement;
    }
}
