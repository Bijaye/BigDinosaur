package org.bd.core.content.database;

public class BdTreeClusterNode
{
  public BdTreeClusterNode( BdtreeMultipleNode x)
  {
    leftnode = null;
    this.x = x;
  }
  BdTreeClusterNode leftnode;
  BdTreeClusterNode rightnode;
  BdtreeMultipleNode x;



public BdtreeMultipleNode getX()
{
  return x;
}
public BdTreeClusterNode getleft()
{
  return leftnode;
}
BdTreeClusterNode add(BdTreeClusterNode node,BdtreeMultipleNode data,int checker){
  if(node==null){
     node =new BdTreeClusterNode(data);
  }
  else{
    if(checker==1){
    
      BdTreeClusterNode left=   node.leftnode;
      BdTreeClusterNode nodeleft=   add(left, data,checker);
    node.leftnode=nodeleft;
    }
    else{
      BdTreeClusterNode left=   node.rightnode;
      BdTreeClusterNode nodeleft=   add(left, data,checker);
      node.rightnode=nodeleft;
      
    
    
  }
  }
  return node;
}
  


}
