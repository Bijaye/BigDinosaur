package com.base.easy.support;

import java.util.ArrayList;

public class EasyArrayList<K> extends ArrayList<K> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3774642849963537738L;

	public EasyArrayList<K> getList(){
		return new EasyArrayList<K>();
	}

}
