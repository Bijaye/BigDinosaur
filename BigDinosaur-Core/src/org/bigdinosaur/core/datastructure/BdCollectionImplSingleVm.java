package org.bigdinosaur.core.datastructure;

public class BdCollectionImplSingleVm<E> extends   BdAbstractCollection<E> implements BdSingleVmDs
{

  @Override
  public boolean isEmpty()
  {
    // how the logic is implemented for isEmpty is dependent on logic inside defaultImpl
    defaultImpl();
    
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean contains(Object o)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean add(E e)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean addAllowDublicate(E e)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean remove(Object o)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean containsAll(BdCollection<?> c)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void clear()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public boolean addAll(BdCollection<? extends E> c)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean addPriority(Object obj, String prioritylevel)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Object Search(Object obj)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Object checkDublicate(Object obj)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BdCollection sort(BdCollection coll)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BdCollection getInInsertionOrder(BdCollection coll)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BdCollection getSorted(BdCollection coll)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BdCollection getUniqueObjects(BdCollection coll)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BdCollection getSortedByKey(BdCollection coll)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BdCollection getSortedByKeyValueInsertionOrder(BdCollection coll)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int countNodes(BdCollection coll)
  {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public boolean put(Object key, Object value)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean get(Object key)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean delete(Object key)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int size()
  {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public BdIterator<E> iterator()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void defaultImpl()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public boolean addAllowNoDublicate(E e)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean addAllCheckDublicate(BdCollection<? extends E> c)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Object getObjectByIndex(int index)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BdCollection getInRandomOrder(BdCollection coll)
  {
    // TODO Auto-generated method stub
    return null;
  }

}
