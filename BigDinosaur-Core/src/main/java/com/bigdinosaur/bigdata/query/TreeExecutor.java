package com.bigdinosaur.bigdata.query;

public class TreeExecutor
{
  public static void main(String[] args)
  {
    TreeObject root=new TreeObject(null,null,1);
    root.insert(root,2,true);
    root.insert(root,3,false);
    root.insert(root,4,true);
    root.insert(root,5,false);
    TreeTraversing traversing=new TreeTraversing();
    traversing.printInOrder(root);
  }

}
