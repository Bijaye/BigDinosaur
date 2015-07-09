package com.base.bigdinosaur.master.data;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BusinessDataImpl")
public class BusinessDataImpl implements Master{
	private String start;

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	@Override
	public Object Load() {
		return null;
	}

}
