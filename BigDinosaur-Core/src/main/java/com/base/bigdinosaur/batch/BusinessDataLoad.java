package com.base.bigdinosaur.batch;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BusinessDataLoad")
public class BusinessDataLoad implements BusinessData{
	private Object data;

	@Override
	public Object Load() {
		return null;
	}

}
