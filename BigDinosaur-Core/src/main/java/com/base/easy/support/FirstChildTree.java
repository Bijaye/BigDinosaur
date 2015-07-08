package com.base.easy.support;

import java.util.HashMap;
import java.util.Map;


public abstract class FirstChildTree extends TreeRoot {
	private Map firstchildata = new HashMap();
	
	    public Map getFirstchildata() {
		return firstchildata;
	}

	public void setFirstchildata(Map firstchildata) {
		this.firstchildata = firstchildata;
	}

		public Object get(String param){
		return firstchildata.get(param);
	    }
	

}
