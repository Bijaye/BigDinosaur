package org.bigdinosaur.core.database;


import java.util.HashMap;
import java.util.Map;

// go Recursively  
// everything is key ,value 
// No matter the size of data 
//do i.o  and load from file and key in map as key ,value
// hold upto jvm can handle without affecting performance .
public class BdMap
{
  BdMap layersmap=new BdMap();
  private Map bdmap=new HashMap<>();
  BdMap loadMap(){
    return layersmap;
    
  }
  HashMap<Integer, Object> dataMap = null;
  
  private BdMap(){
dataMap = new HashMap();
  }
  
  public static BdMap get(){
    BdMap BdEventBean = new BdMap();
return BdEventBean;
  }
  
  public BdMap add(int key, Object value){
dataMap.put(key, value);
return this;
  }
  
  public BdMap addAll(Map dataMap){
this.dataMap.putAll(dataMap);
return this;
  }    
  
  public Object get(String key){
return dataMap.get(key);
  }
  
  public String toString(){
return dataMap.toString();
  }
  
  public Map getData(){
return dataMap;
  }
}
