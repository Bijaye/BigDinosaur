package org.bigdinosaur.core.datastructure;

 public abstract class BdAbstractCollection<E> implements BdCollection<E>
{

  @Override
  public int size()
  {
    return 0;
  }

  @Override
  public boolean isEmpty()
  {
    return false;
  }

  @Override
  public boolean contains(Object o)
  {
    return false;
  }

  @Override
  public BdIterator<E> iterator()
  {
    return null;
  }

  @Override
  public Object[] toArray()
  {
    return null;
  }

  @Override
  public <T> T[] toArray(T[] a)
  {
    return null;
  }

  @Override
  public boolean add(E e)
  {
    return false;
  }

  @Override
  public boolean remove(Object o)
  {
    return false;
  }

  @Override
  public boolean containsAll(BdCollection<?> c)
  {
    return false;
  }

  @Override
  public boolean addAll(BdCollection<? extends E> c)
  {
    return false;
  }

  @Override
  public boolean removeAll(BdCollection<?> c)
  {
    return false;
  }

  @Override
  public boolean retainAll(BdCollection<?> c)
  {
    return false;
  }

  @Override
  public void clear()
  {
    
  }

}
