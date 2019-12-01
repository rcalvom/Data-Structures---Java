package Heap;

public class ArrayHeap<T> {
    
    private DynamicArray<DataHeap<T>> Heap;    
    private int NumberElements;
    
    public ArrayHeap() {
        Heap = new DynamicArray<>();
        Heap.add(new DataHeap<>(-1, null));
        NumberElements = 0;
    }
    
    public boolean IsEmpty() {
        return NumberElements == 0;
    }
    
    public int GetNumberOfElements() {
        return NumberElements;
    }
    
    public T Peek() {
        return Heap.get(1).Element;
    }
    
    public T ExtractMax() {
        Heap.Swap(1, NumberElements);
        T element = Heap.remove(NumberElements).Element;
        NumberElements--;
        for (int i = 1; i * 2 <= NumberElements;) {
            int swap = GetMaxPriority(i*2, (i*2)+1);
            int MaxPriority = Heap.get(swap).Priority;
            if (MaxPriority > Heap.get(i).Priority) {
                Heap.Swap(i, swap);
                i = swap;
            } else {
                break;
            }
        }
        return element;
    }
    
    public void Insert(int Priority, T element) {
        DataHeap<T> newElement = new DataHeap<>(Priority, element);
        Heap.add(newElement);
        NumberElements++;
        int i = NumberElements;
        while (i > 1 && Heap.get(i).Priority > Heap.get(i/2).Priority) {
            Heap.Swap(i, i/2);
            i /= 2;
        }
    }
    
    public String ToString() {
        String s = "[";
        for (int i = 1; i<= NumberElements; i++) {
            s = s + " (" + Heap.get(i).Element.toString() + ", " + Heap.get(i).Priority + " ), ";
        }
        return s.substring(0, s.length()-2) + " ]";
    }
    
    private int GetMaxPriority(int indexOne, int indexTwo) {
        if (indexTwo>NumberElements) {
            return indexOne;
        }
        int PriorityOne = Heap.get(indexOne).Priority, PriorityTwo = Heap.get(indexTwo).Priority;
        return (PriorityOne > PriorityTwo) ? indexOne : indexTwo;
    }
    
    private class DataHeap<E> {
        private int Priority;
        private E Element;

        public DataHeap() {

        }

        public DataHeap(int Priority, E Element) {
            this.Priority = Priority;
            this.Element = Element;
        }
        
    }
    
}
