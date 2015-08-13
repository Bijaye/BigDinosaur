package org.bigdinosaur.core.datastructure;


public interface BdIterator<E> {
   
    boolean hasNext();

   
    E next();

 
    void remove();
}
