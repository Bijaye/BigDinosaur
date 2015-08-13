package com.bigdinosaur.bigdata.query.asplatform;

public class TreeObject
{
private TreeObject nodeleft;
public TreeObject(TreeObject nodeleft, TreeObject noderight, int treevalue)
{
  super();
  this.nodeleft = nodeleft;
  this.noderight = noderight;
  this.treevalue = treevalue;
}


void insert(TreeObject treeobject,int nodevalue,boolean isleft){
  if(isleft){
  if(treeobject.getNodeleft()==null){
    TreeObject nodeleft=   treeobject.getNodeleft();
    nodeleft  =new  TreeObject(null,null,nodevalue);
    
    treeobject.setNodeleft(nodeleft);
    System.out.println("<<< Inserted" + treeobject.getNodeleft().getTreevalue()+" in Left Node>>");
  }
  else{
  // node left also have left  and right node  
    TreeObject nodeleft=   treeobject.getNodeleft();
    insert(nodeleft,nodevalue,true);
//    TreeObject nodeleftchild  =new  TreeObject(null,null,nodevalue);
//    nodeleft.setNodeleft(nodeleftchild);
  }
  }
  if(!isleft){
  if(treeobject.getNoderight()==null ){
    TreeObject noderight=   treeobject.getNoderight();
    noderight  =new  TreeObject(noderight,null,nodevalue);
    treeobject.setNoderight(noderight);
    System.out.println("<<< Inserted"+treeobject.getNoderight().getTreevalue()+" in right Node>>");
    
  }
  else{
    TreeObject noderight=   treeobject.getNoderight();
    insert(noderight,nodevalue,false);
//    TreeObject noderightchild  =new  TreeObject(noderight,null,nodevalue);
//    noderight.setNoderight(noderightchild);
    
  }
  
  }
}
public TreeObject getNodeleft()
{
  return nodeleft;
}
public void setNodeleft(TreeObject nodeleft)
{
  this.nodeleft = nodeleft;
}
public TreeObject getNoderight()
{
  return noderight;
}
public void setNoderight(TreeObject noderight)
{
  this.noderight = noderight;
}
public int getTreevalue()
{
  return treevalue;
}
public void setTreevalue(int treevalue)
{
  this.treevalue = treevalue;
}
private TreeObject noderight;
private int treevalue;

}
