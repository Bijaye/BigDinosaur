package com.bd.documentmanagement.dir.jvm;

import org.bd.core.content.database.BdFileDirSingleVm;
import org.bd.core.content.database.BdtreeMultipleNode;

public class BdFileDirMultipleVmTest
{ public void main(String[] args)
{
  //BdFileDirSingleVm gives all directory contents of single vm 
  // BdtreeMultipleNode gives all contents in multiple vm 
  BdtreeMultipleNode tree = new BdtreeMultipleNode(new BdFileDirSingleVm());
  tree.add(tree, new BdFileDirSingleVm(),1);
  tree.add(tree, new BdFileDirSingleVm(),1);
  tree.add(tree, new BdFileDirSingleVm(),1);
  tree.add(tree, new BdFileDirSingleVm(),1);
  tree.add(tree, new BdFileDirSingleVm(),1);
  tree.add(tree, new BdFileDirSingleVm(),1);
  tree.add(tree, new BdFileDirSingleVm(),1);
  tree.add(tree, new BdFileDirSingleVm(),1);
  tree.add(tree, new BdFileDirSingleVm(),1);
  System.out.println(tree);

}

}
