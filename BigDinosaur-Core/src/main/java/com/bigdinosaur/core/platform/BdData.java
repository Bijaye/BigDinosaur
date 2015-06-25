package com.bigdinosaur.core.platform;

public abstract class BdData
{
  // it implies to int value in big data station
Object getInt(Object obj){
  return obj;
  
}
// it depends on business logic so it is abstract
//  Int have different meaning according  to industry 
//needs
abstract Object getIntInterPretation(Object obj);
}