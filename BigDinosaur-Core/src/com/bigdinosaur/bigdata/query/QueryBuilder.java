package com.bigdinosaur.bigdata.query;

import com.bigdinosaur.core.dmanagement.TreeNode;

public interface QueryBuilder
{

  TreeNode buildTreeNodeForContainer();
  TreeNode  buildTreeNodeForGroup();
  TreeNode buildTreeNodeForOrganization();
  TreeNode buildTreeNodeForSite();
  TreeNode  buildTreeNodeForRole();
  TreeNode buildTreeNodeForTeam();
  TreeNode buildTreeNodeForFolder();
}
