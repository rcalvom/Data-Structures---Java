package DisjointSet;

public interface Set<T> {
    Map<T> union (Map<T> A, Map<T> B);
    //Map<T> intersection (Map<T> A, Map<T> B);
    //Map<T> diference (Map<T> A, Map<T> B);
    boolean isSubset (Map<T> A, Map<T> B);
    boolean belongs(Map<T> A, Map<T> B);
    Map<T> insert (T x, Map<T> A);
    Map<T> remove (T x, Map<T> A);
}
