package com.bd.documentmanagement.dir.jvm;

import org.bd.core.content.database.BdFileDirSingleVm;
import org.bd.core.content.database.Bdtree;

public class BdFileDirSingleVmTest
{
  
  public class NodeImpl
  {
    public void main(String[] args)
    {
      Bdtree tree = new Bdtree(new BdFileDirSingleVm());
      tree.add(tree, new BdFileDirSingleVm());
      tree.add(tree, new BdFileDirSingleVm());
      tree.add(tree, new BdFileDirSingleVm());
      tree.add(tree, new BdFileDirSingleVm());
      tree.add(tree, new BdFileDirSingleVm());
      tree.add(tree, new BdFileDirSingleVm());
      tree.add(tree, new BdFileDirSingleVm());
      tree.add(tree, new BdFileDirSingleVm());
      tree.add(tree, new BdFileDirSingleVm());
      System.out.println(tree);

    }
  }
}
