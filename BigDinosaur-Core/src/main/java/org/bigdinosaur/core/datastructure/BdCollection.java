package org.bigdinosaur.core.datastructure;

public interface BdCollection<E> extends BdIterable<E> {
   
    int size();
    boolean isEmpty();

    boolean contains(Object o);
   
    BdIterator<E> iterator();
   
    Object[] toArray();

    <T> T[] toArray(T[] a);
    
    boolean add(E e);
   
    boolean remove(Object o);

    
    boolean containsAll(BdCollection<?> c);

   
    boolean removeAll(BdCollection<?> c);

   
    boolean retainAll(BdCollection<?> c);

   
    void clear();


    boolean equals(Object o);

   
    int hashCode();
    boolean addAll(BdCollection<? extends E> c);
}
