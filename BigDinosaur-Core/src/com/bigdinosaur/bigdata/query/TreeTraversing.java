package com.bigdinosaur.bigdata.query;


public class TreeTraversing
{

  public void printInOrder(TreeObject node) {
    if (node != null) {
      printInOrder(node.getNodeleft());
      System.out.println("  Traversed " + node.getTreevalue());
      printInOrder(node.getNoderight());
    }
}}
