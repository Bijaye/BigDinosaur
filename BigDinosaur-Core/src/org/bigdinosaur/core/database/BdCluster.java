package org.bigdinosaur.core.database;

import java.util.List;

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
Object getObjectType();
Object getObjectInstance();
Object getfileInstance();
Object getObjectNo();
Object getMaxShareMemory();
Object getMinShareMemory();
Object getfairShareMemory();
Object writeObjects(Object obj,Object objectlist,Object objecttype);
// if there are a.txt and b.txt then getInputPathToProcess=2
Object getInputPathToProcess(Object jobobject);
Object sendPersistSignal(Object signal);
Object sendFileUpdateSignal(Object signal);
Object writeObject(Object obj);

//byte[0],byte[1] ... and so on byte[n]
//byte[0]=object.getSomeProperty();
byte[] encodeObjectToByte(Object object);
 Object decodeByteToObject(byte[] value);
 Object getFileSize();
 // every object is a new type by itself .The character of data it holds determine the 
 // type of object 
 List<Object>getTypeList();
 //convert jdkobject java object to Big Dinosaur object,providing new extra features supported from framework
 Object makeBdObject(Object jdkobject);



}
