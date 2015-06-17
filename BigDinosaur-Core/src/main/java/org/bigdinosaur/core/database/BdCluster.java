package org.bigdinosaur.core.database;
// it is the combination of master node and slaves nodes
public interface BdCluster
{
  // 
Object  getMasterNode();
Object [] getSlavesNode();
Object getClusterAllocatedMemory();
Object getClusterAvailableMemory();
Object getClusterAllocatedCore();
Object getClusterAvailableCore();
Object getJvmFreeMemory();
Object getJvmavailableMemory();
Object getJvmTotalMemory();
Object getNoOfClusterRunningApplicaiton();
Object getNoOfClusterRunningContainer();



}
