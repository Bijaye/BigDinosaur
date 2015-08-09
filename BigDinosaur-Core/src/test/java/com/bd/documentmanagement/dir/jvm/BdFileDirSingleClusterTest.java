package com.bd.documentmanagement.dir.jvm;

import org.bd.core.content.database.BdFileDirSingleVm;
import org.bd.core.content.database.BdTreeClusterNode;
import org.bd.core.content.database.BdtreeMultipleNode;


//this cluster contains collection of jvms file contents 
// it is single cluster tree 
public class BdFileDirSingleClusterTest
{ public void main(String[] args)
{
  //BdFileDirSingleVm gives all directory contents of single vm 
  // BdtreeMultipleNode gives all contents in multiple vm and act as a cluster 
  
  BdTreeClusterNode tree = new BdTreeClusterNode(new BdtreeMultipleNode(new BdFileDirSingleVm()));
  tree.add(tree, new BdtreeMultipleNode(new BdFileDirSingleVm()),1);
  tree.add(tree, new BdtreeMultipleNode(new BdFileDirSingleVm()),1);
  tree.add(tree, new BdtreeMultipleNode(new BdFileDirSingleVm()),1);
  tree.add(tree, new BdtreeMultipleNode(new BdFileDirSingleVm()),1);
  tree.add(tree, new BdtreeMultipleNode(new BdFileDirSingleVm()),1);
  tree.add(tree, new BdtreeMultipleNode(new BdFileDirSingleVm()),1);
  tree.add(tree, new BdtreeMultipleNode(new BdFileDirSingleVm()),1);
  tree.add(tree, new BdtreeMultipleNode(new BdFileDirSingleVm()),1);
  tree.add(tree, new BdtreeMultipleNode(new BdFileDirSingleVm()),1);
  System.out.println(tree);

}

}
