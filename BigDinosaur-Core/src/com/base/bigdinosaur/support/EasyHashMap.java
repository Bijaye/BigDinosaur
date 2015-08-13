package com.base.bigdinosaur.support;

import java.util.HashMap;

public class EasyHashMap<K, V> extends HashMap<K, V> {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2543911991811983277L;

	public EasyHashMap<K, V> getMap(){
		return (EasyHashMap<K, V>) new HashMap<K, V>();
	}
	
	
	
}