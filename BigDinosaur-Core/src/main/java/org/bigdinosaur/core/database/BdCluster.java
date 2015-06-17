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
Object getQueueAllocatedMemory(Object queuename);
Object getUsuageMemory();
Object getDemandMemory();
Object getMaxShareMemory();
Object getMinShareMemory();
Object getfairShareMemory();
// if there are a.txt and b.txt then getInputPathToProcess=2
Object getInputPathToProcess(Object jobobject);



}
