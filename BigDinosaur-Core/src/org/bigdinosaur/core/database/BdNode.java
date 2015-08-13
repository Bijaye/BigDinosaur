package org.bigdinosaur.core.database;


// Objects that exists in BdGraph
public interface BdNode
{
  BdCore getBdCore();
  public String getNetworkLocation();
  public void setNetworkLocation(String location);
  public String getName();
  public BdNode getParent();
  public void setParent(BdNode parent);
  /** Return this node's level in the tree.
   * E.g. the root of a tree returns 0 and its children return 1
   */
  public int getLevel();
  /** Set this node's level in the tree.*/
  public void setLevel(int i);
  

}
