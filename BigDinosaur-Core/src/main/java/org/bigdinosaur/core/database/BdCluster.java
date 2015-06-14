package org.bigdinosaur.core.database;
// it is the combination of master node and slaves nodes
public interface BdCluster
{
Object  getMasterNode();
Object [] getSlavesNode();

}
