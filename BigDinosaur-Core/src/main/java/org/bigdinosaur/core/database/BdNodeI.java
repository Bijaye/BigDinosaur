package org.bigdinosaur.core.database;

import java.util.ArrayList;
import java.util.List;

public class BdNodeI 
{
  List<BdNode> listnodes=new ArrayList<BdNode>();

  public List<BdNode> getListnodes()
  {
    return listnodes;
  }

  public void setListnodes(List<BdNode> listnodes)
  {
    this.listnodes = listnodes;
  }
  

}
