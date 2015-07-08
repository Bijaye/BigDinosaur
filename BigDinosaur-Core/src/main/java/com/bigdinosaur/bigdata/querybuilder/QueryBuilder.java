package com.bigdinosaur.bigdata.querybuilder;

import com.bigdinosaur.bigdata.folderastree.TreeNode;

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
