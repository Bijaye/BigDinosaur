package org.bigdinosaur.core.database;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// go Recursively  
// everything is key ,value 
// No matter the size of data 
//do i.o  and load from file and key in map as key ,value
// hold upto jvm can handle without affecting performance .
public class BdMap
{
//  BdMap layersmap=new BdMap();
//  BdMap loadMap(){
//    return layersmap;
//    
//  }
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
  public BdMap put(Integer key,Object value){
    this.dataMap.put(key, value);
    return this;
      }
  public Object get(Object key){
return dataMap.get(key);
  }
  
  public String toString(){
return dataMap.toString();
  }
  
  public Map getData(){
return dataMap;
  }
  
  public Integer getKey(String value){
    for (Entry<Integer, Object> entry : dataMap.entrySet()) {
      if (entry.getValue().equals(value)) {
          System.out.println(entry.getKey());
          return entry.getKey();
      }
  }
    return null;
  }
  
  
}
