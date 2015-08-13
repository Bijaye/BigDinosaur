package com.bigdinosaur.objectgraph;
// retrive object on the basis of location preallocated for object
// simple algorithm
public interface BdObjectGraph
{
  // Object Graph is a tree representation of BD object.
  // From root node to sub child node to finally leaf object graph shows the location of object.
  // for example 
  //root=station,
  //station has 3 clusters=Nodes
  // Clusters has many objects for example file objects,schedule objects 
  // then sub-node=file object,schedule object 
  //Each node has resource description allocator,for example if i want to get file object in clsuter1
  //in station1 then resource description allocator of Big Dinosaur gives me 
  //stationname,clustername,filename as a query 
  //the syntax for query has to be decided in what format
  // may be station:cluster:where:filename="big dinosaur u will rule "
  //Challenges:On what interval of time the BdObjectGraph has to be persist or it is stored in file system or create object
  //in runtime 
//////////////////////////////////
  //May be representing tree in file system or in object  
  
  //for Example Example 1
  // Bd has different types of object graph on the basis of object type
 // which tree as object graph to search is determined on the basis of query syntax
 // for example
 // Station:Abcbankclientstation(in sense it represent one machine virtually but is a collection of many physical clusters or virtual clusters)
 // this will search station tree object with key as Abcbankclientstation.It goes on traversing on tree until it gets Abcbankclientstation and gets space object allcoated for this client in sense of cluster 

  //for Example Example 2
  //Now after transversing cluster object with allocated space is retirved then again i need to retirve file object from that cluster
  //then again the query is 
  //Station:Abcbankclientstation:insurancestore:abishkar.txt
  //now again file object graph tree is traversed until i get abishkar.txt and goes on recusrsively
  //or 
  //Station:Abcbankclientstation:insurancestore:insuranceObject
  //insurancestore has large no of insuranceObject kept as tree,so again insurancestore is traversed until
  //insuranceObject is retirved and goes on recusrsively 
  
  
  //Object graph is continuously updated ot inserted by another program in continuous basis on the basis of tree type object
  
}
