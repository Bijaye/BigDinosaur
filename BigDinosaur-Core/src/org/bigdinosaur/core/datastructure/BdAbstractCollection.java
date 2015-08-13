package org.bigdinosaur.core.datastructure;




 public abstract class BdAbstractCollection<E> implements BdCollection<E>
{

  abstract public int size();
 

  @Override
  public boolean isEmpty()
  {
    return (size()==0);
 
  }

  @Override
  public boolean contains(Object o)
  {
    BdIterator<E> iterator= iterator();
    while(iterator.hasNext()){
      Object obj=  iterator.next();
      if(obj.equals(o)){
        return true;
      }
      
    }
    return false;
    
      
    }

  public abstract BdIterator<E> iterator();
   





  @Override
  public boolean add(E e)
  {
    return false;
  }

  @Override
  public boolean remove(Object o)
  {
    BdIterator iterator= iterator();
  if(iterator.hasNext()){
   Object obj= iterator.next();
   iterator.remove();
   
  }
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
    BdIterator<? extends E> iterator=  c.iterator();
    if(iterator.hasNext()){
      E obj=(E) iterator.next();
      add(obj);
      
    }
    return true;
  }



 

  @Override
  public void clear()
  {
    BdIterator<?> iterator= iterator();
    if(iterator.hasNext()){
      
      iterator.remove();
      
    }
    
  }

}
