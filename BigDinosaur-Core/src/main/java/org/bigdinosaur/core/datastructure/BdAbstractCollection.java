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
  public boolean add(E e)
  {
    return false;
  }

  @Override
  public boolean remove(Object o)
  {
    return false;
  }

 

//  BdArrayList<BdFileDirSingleVm> clusterarrlist = new BdArrayList<BdFileDirSingleVm>(5);
  // From One JVM it return object of type BdFileDirSingleVm
//From another JVM it return object of type BdFileDirSingleVm
//From another JVM it return object of type BdFileDirSingleVm
  //so add all providea mechanism to add objects at once for all jvm 
//  BdArrayList<BdFileDirSingleVm> arrlist1 = new BdArrayList<BdFileDirSingleVm>(5);
//  BdArrayList<BdFileDirSingleVm> arrlist2 = new BdArrayList<BdFileDirSingleVm>(5);
//  BdArrayList<BdFileDirSingleVm> arrlist3 = new BdArrayList<BdFileDirSingleVm>(5);
//  clusterarrlist.addAll(arrlist1);
//  clusterarrlist.addAll(arrlist2);
//  clusterarrlist.addAll(arrlist3);
  
  
  @Override
  public boolean addAll(BdCollection<? extends E> c)
  {
    return false;
  }



 

  @Override
  public void clear()
  {
    
  }

}
