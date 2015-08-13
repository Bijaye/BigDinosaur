package com.base.bigdinosaur.master.data;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BusinessDataLoad")
public class BusinessDataLoad implements BusinessData{
	private Object data;

	@Override
	public Object Load() {
		return null;
	}

}
