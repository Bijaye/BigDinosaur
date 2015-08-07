package org.bd.core.content.database;

public class BdtreeMultipleNode
{
  public BdtreeMultipleNode( BdFileDirSingleVm x)
  {
    leftnode = null;
    this.x = x;
  }
  BdtreeMultipleNode leftnode;
  BdtreeMultipleNode rightnode;
  BdFileDirSingleVm x;



public BdFileDirSingleVm getX()
{
  return x;
}
public BdtreeMultipleNode getleft()
{
  return leftnode;
}
BdtreeMultipleNode add(BdtreeMultipleNode node,BdFileDirSingleVm data,int checker){
  if(node==null){
     node =new BdtreeMultipleNode(data);
  }
  else{
    if(checker==1){
    
      BdtreeMultipleNode left=   node.leftnode;
      BdtreeMultipleNode nodeleft=   add(left, data,checker);
    node.leftnode=nodeleft;
    }
    else{
      BdtreeMultipleNode left=   node.rightnode;
      BdtreeMultipleNode nodeleft=   add(left, data,checker);
      node.rightnode=nodeleft;
      
    
    
  }
  }
  return node;
}
  


}
