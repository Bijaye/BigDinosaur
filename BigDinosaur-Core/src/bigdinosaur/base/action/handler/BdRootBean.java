package bigdinosaur.base.action.handler;

import java.util.HashMap;
import java.util.Map;

public abstract class BdRootBean {
    Map additionalData = new HashMap();
    
    public void setAdditionalData(Map additionalData){
  this.additionalData = additionalData;
    }
    public Object get(String param){
  return additionalData.get(param);
    }
}