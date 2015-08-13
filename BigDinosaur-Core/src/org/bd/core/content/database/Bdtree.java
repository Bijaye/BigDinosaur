package org.bd.core.content.database;
//should be able to insert,countnodes,delete ,search,checkempty for content BdFileDirSingleVm
public class Bdtree
{
  public Bdtree( BdFileDirSingleVm x)
  {
   node = null;
    this.x = x;
  }
  Bdtree node;
  BdFileDirSingleVm x;



public BdFileDirSingleVm getX()
{
  return x;
}
public Bdtree getleft()
{
  return node;
}
public Bdtree add(Bdtree node,BdFileDirSingleVm data){
  if(node==null){
     node =new Bdtree(data);
  }
  else{
    
    Bdtree left=   node.node;
    Bdtree nodeleft=   add(left, data);
    node.node=nodeleft;
    
    
  }
  return node;
}
  


}
