package org.bigdinosaur.core.ds;


public interface BdIterator<E> {
   
    boolean hasNext();

   
    E next();

 
    void remove();
}
