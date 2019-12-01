package DisjointSet;

public class Map<T> implements Set<T>{

    public T element;
    public Map<T> parent;
    public int height;

    public Map(T element, Map<T> parent) {
        this.element = element;
        this.parent = parent;
        this.height = 0;
    }
    
    public Map<T> Key(Map<T> parent){
        if(parent == this){
            return this;
        }else{
            return Key(parent);
        }
    }

    @Override
    public Map<T> union(Map<T> A, Map<T> B) {    
        if(A == B){
            return A;
        }else if(A.height > B.height){
            if(A.height == B.height){
                A.height++;
            }
            B.parent = A;
            return A;
        }else{
            if(A.height == B.height){
                B.height++;
            }
            A.parent = B;
            return B;
        }
    }

    @Override
    public boolean isSubset(Map<T> A, Map<T> B) {
        return A == B;
    }

    @Override
    public boolean belongs(Map<T> A, Map<T> B) {
        return A == B;
    }

    @Override
    public Map<T> insert(T x, Map<T> A) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<T> remove(T x, Map<T> A) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
