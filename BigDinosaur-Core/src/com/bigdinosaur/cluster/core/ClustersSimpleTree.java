package com.bigdinosaur.cluster.core;

public interface ClustersSimpleTree
{
  // Object will be replaced later
  Object createRootTreeNode(Object root);
  Object setHasChildren(Object root);
  Object isTree(Object root);
  Object getChildquery(Object root);
  Object doWalkThroughTree(Object root);
  Object buildTreeNodeForCreate(Object root);
  Object  buildTreeNodeForUpdate(Object root);
  Object undoCheckout(Object root);
  //List<TreeNode> objects = new ArrayList<TreeNode>();
  // use Cutom tree with pre Implemented data structure ,better use own data structure
  Object WrapTreeNode(Object root);

}
