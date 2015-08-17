package org.bigdinosaur.core.ds;

import java.util.HashMap;
import java.util.Map;

public class EasyHashMap<K, V> extends HashMap<K, V> {
	


	private static final long serialVersionUID = 2543911991811983277L;

	public EasyHashMap<K, V> getMap(){
		return (EasyHashMap<K, V>) new HashMap<K, V>();
	}
	
//	public EasyArrayList<K> getList(){
//    return new EasyArrayList<K>();
//  }

	 private Map firstchildata = new HashMap();
	  
   public Map getFirstchildata() {
 return firstchildata;
}

public void setFirstchildata(Map firstchildata) {
 this.firstchildata = firstchildata;
}

 public Object getData(String param){
 return firstchildata.get(param);
   }
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