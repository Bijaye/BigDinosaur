package org.bd.core.database;
//visualize in terms of file system 
public class BdTree
{
  String rootdata;
  BdNode root;
  
  
  BdNode nodeleft;
  BdNode noderight;
  BdNode nodrightplus;
  BdNode nodeleftplus;
  BdNode getNode(){
    return new BdNode();
  }
  void addleft(){
    
  }
 void addright(){
    
  }
 void addData(){
   root= getRoot();
   if(root==null){
     root=new BdNode();
     
   }
   
   
   
 }
  
  public static void main(String[] args)
  {
    BdTree tree=new BdTree();
    tree.addData();
  }
  
  public String getRootdata()
  {
    return rootdata;
  }
  public BdNode getRoot()
  {
    return root;
  }
  public BdNode getNodeleft()
  {
    return nodeleft;
  }
  public BdNode getNoderight()
  {
    return noderight;
  }
  public BdNode getNodrightplus()
  {
    return nodrightplus;
  }
  public BdNode getNodeleftplus()
  {
    return nodeleftplus;
  }
  public void setRootdata(String rootdata)
  {
    this.rootdata = rootdata;
  }
  public void setRoot(BdNode root)
  {
    this.root = root;
  }
  public void setNodeleft(BdNode nodeleft)
  {
    this.nodeleft = nodeleft;
  }
  public void setNoderight(BdNode noderight)
  {
    this.noderight = noderight;
  }
  public void setNodrightplus(BdNode nodrightplus)
  {
    this.nodrightplus = nodrightplus;
  }
  public void setNodeleftplus(BdNode nodeleftplus)
  {
    this.nodeleftplus = nodeleftplus;
  }

}
