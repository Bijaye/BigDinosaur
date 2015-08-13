package com.base.bigdinosaur.support;


import java.util.HashMap;
import java.util.Map;

public abstract class TreeRoot {
    Map rootData = new HashMap();
    
   
    public Object get(String param){
	return rootData.get(param);
    }


	public Map getRootData() {
		return rootData;
	}


	public void setRootData(Map rootData) {
		this.rootData = rootData;
	}
}