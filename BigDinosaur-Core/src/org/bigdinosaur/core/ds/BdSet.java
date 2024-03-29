package org.bigdinosaur.core.ds;



public abstract interface BdSet<E>
    extends BdCollection<E>
{
  public abstract int size();

  public abstract boolean isEmpty();

  public abstract boolean contains(Object paramObject);

  public abstract BdIterator<E> iterator();

  public abstract Object[] toArray();

  public abstract <T> T[] toArray(T[] paramArrayOfT);

  public abstract boolean add(E paramE);

  public abstract boolean remove(Object paramObject);

  public abstract boolean containsAll(BdCollection<?> paramCollection);

  public abstract boolean addAll(BdCollection<? extends E> paramCollection);



  public abstract boolean removeAll(BdCollection<?> paramCollection);

  public abstract void clear();

  public abstract boolean equals(Object paramObject);

  public abstract int hashCode();
}