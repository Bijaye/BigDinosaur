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
   boolean  addPriority(Object obj,String prioritylevel);
   Object Search(Object obj);
   Object checkDublicate(Object obj);
   BdCollection  sort(BdCollection coll);
   BdCollection getInInsertionOrder(BdCollection coll);
   BdCollection getSorted(BdCollection coll);
   // no dublication allowed 
   BdCollection getUniqueObjects(BdCollection coll);
   BdCollection getSortedByKey(BdCollection coll);
   BdCollection getSortedByKeyValueInsertionOrder(BdCollection coll);
   int countNodes(BdCollection coll);
  boolean put(Object key,Object value);
  boolean get(Object key);
  boolean delete(Object key);
  
}
