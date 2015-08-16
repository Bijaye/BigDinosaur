package bigdinosaur.base.action.handler;

import java.util.HashMap;
import java.util.Map;

public class BdBdEventBean {
    public static String TYPE = null;
    
    HashMap<String, Object> dataMap = null;
    
    private BdBdEventBean(){
  dataMap = new HashMap();
    }
    
    public static BdBdEventBean get(){
      BdBdEventBean BdEventBean = new BdBdEventBean();
  return BdEventBean;
    }
    
    public BdBdEventBean add(String key, Object value){
  dataMap.put(key, value);
  return this;
    }
    
    public BdBdEventBean addAll(Map dataMap){
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