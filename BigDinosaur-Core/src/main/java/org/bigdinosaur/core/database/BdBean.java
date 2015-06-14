package com.bigdinosaur.event;

import java.util.HashMap;
import java.util.Map;

public class BdBean {
    public static String TYPE = null;
    
    HashMap<String, Object> dataMap = null;
    
    private BdBean(){
  dataMap = new HashMap();
    }
    
    public static BdBean get(){
      BdBean BdEventBean = new BdBean();
  return BdEventBean;
    }
    
    public BdBean add(String key, Object value){
  dataMap.put(key, value);
  return this;
    }
    
    public BdBean addAll(Map dataMap){
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