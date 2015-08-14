package org.bigdinosaur.core.database.test;


import org.bigdinosaur.core.database.BdDataBase;

public class BdDataBaseTest
{
  public static void main(String[] args)
  {
    // Input 
    //DatabaseName:HistoryData:ObjectType:ErrorObject
    //OutPut 
    //List of errorObject
    //Imp:data normalization is very important consider this .Should not have redundancy in used space and in object retrieve process
  
      
    }
  
BdDataBase getSingleClusterDatabase(){
  return new BdDataBase();
  

}
BdDataBase getMultipleClusterMultipleDatabase(String pattern){
  return new BdDataBase();
  

}
BdDataBase getSingleClusterHistoryDatabase(String pattern){
  return new BdDataBase();
  

}

BdDataBase getSingleClusterAllDatabases(String pattern){
  return new BdDataBase();
  

}
BdDataBase getSingleClusterSessionDatabase(String pattern){
  return new BdDataBase();
  

}
BdDataBase getSingleClusterServiceDatabase(String pattern){
  return new BdDataBase();
  

}
BdDataBase getHistoryTreeSingleCluster(String pattern){
  return new BdDataBase();
}
BdDataBase getHistoryTreeMultipleCluster(String pattern){
  return new BdDataBase();
}
// 10 thousand nodes is supposed to be supported by big BigDinosaur platform
int getMaxClusterNodes(){
  return 0;
  
}
int getMaxDataBaseOnAllCluster(){
  return 0;
  
}
}