package org.bigdinosaur.core.ds;
// random access in a LinkedList is O(n), while it's O(1) in an ArrayList
//Many data structures (e.g. Stacks, Queues, Binary Trees) are often implemented using the concept of linked lists
// The benefit of using circular list is that appending to end can be done quickly
public interface BdCollection<E> extends BdIterable<E> {
   
  
  // below is the method definition and polymorphic algorithm can be applied on below 
 // mentioned method impl
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    BdIterator<E> iterator(); 
    boolean add(E e);
    boolean addAllowDublicate(E e);
    boolean addAllowNoDublicate(E e);
    boolean remove(Object o);
    boolean containsAll(BdCollection<?> c);
    void clear();
    boolean equals(Object o);
    int hashCode();
    boolean addAll(BdCollection<? extends E> c);
    boolean addAllCheckDublicate(BdCollection<? extends E> c);
   boolean  addPriority(Object obj,String prioritylevel);
   Object getObjectByIndex(int index);
   Object Search(Object obj);
   Object checkDublicate(Object obj);
   BdCollection  sort(BdCollection coll);
   BdCollection getInInsertionOrder(BdCollection coll);
   BdCollection getInRandomOrder(BdCollection coll);
   
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
