package org.bigdinosaur.core.datastructure;


public interface BdIterable<T> {

    BdIterator<T> iterator();
}