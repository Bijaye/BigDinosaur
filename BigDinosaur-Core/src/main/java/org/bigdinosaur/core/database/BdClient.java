package org.bigdinosaur.core.database;
//Big Dinosaur has many clients on the basis of evolution of api it goes on 
//for mapreduce it has following clients 
//Client types:BdCoreClient,BdCommonClient,BdAppClient,BdHistoryClient,BdJobClient
// for every client of map reduce unit test is necessary starting from core client 
public interface BdClient
{
Object readFiles();
Object readBlocks();
Object createBlock();
Object deleteBlock();
Object replicateBlock();


}
