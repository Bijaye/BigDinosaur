package com.bigdinosaur.cluster.core;

import java.util.List;

import com.bigdinosaur.cluster.core.BdNode;
// single cluster has combination of nodes
public interface BdClusterTree
{
List<BdNode> getBdNodes();
}
