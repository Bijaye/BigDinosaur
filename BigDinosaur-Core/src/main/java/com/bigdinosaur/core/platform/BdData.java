package com.bigdinosaur.core.platform;

import java.util.List;

public abstract class BdData
{
  // it implies to int value in big data station
  
  abstract List<Object>getdataAsychronousOrQueue();
Object getInt(Object obj){
  return obj;
  
}
Object getFloat(Object obj){
  return obj;
  
}
Object getCharacter(Object obj){
  return obj;
  
}

Object getbits(Object obj){
  return obj;
  
}
Object gethex(Object obj){
  return obj;
  
}
Object getoct(Object obj){
  return obj;
  

}
Object getEncrypted(Object obj){
  return obj;
  

}
// it depends on business logic so it is abstract
//  Int have different meaning according  to industry 
//needs
abstract Object getIntInterPretation(Object obj);

abstract Object getFloatInterPretation(Object obj);


}