package org.bigdinosaur.core.datastructure;

public interface BdCollection<E> extends BdIterable<E> {
   
    int size();
    boolean isEmpty();

    boolean contains(Object o);
   
    BdIterator<E> iterator();
   
  
    
    boolean add(E e);
   
    boolean remove(Object o);

    
    boolean containsAll(BdCollection<?> c);

   

   

   
    void clear();


    boolean equals(Object o);

   
    int hashCode();
    boolean addAll(BdCollection<? extends E> c);
}
