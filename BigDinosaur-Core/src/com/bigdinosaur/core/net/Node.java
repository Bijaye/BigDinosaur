package com.bigdinosaur.core.net;


public interface Node {
  /** @return the string representation of this node's network location */
  public String getNetworkLocation();

  /** Set this node's network location
   * @param location the location
   */
  public void setNetworkLocation(String location);

  /** @return this node's name */
  public String getName();

  /** @return this node's parent */
  public Node getParent();

  /** Set this node's parent
   * @param parent the parent
   */
  public void setParent(Node parent);

  /** @return this node's level in the tree.
   * E.g. the root of a tree returns 0 and its children return 1
   */
  public int getLevel();

  /** Set this node's level in the tree
   * @param i the level
   */
  public void setLevel(int i);
}
