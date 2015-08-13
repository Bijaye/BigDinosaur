package com.base.bigdinosaur.batch;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("DevelopmentDataImpl")
public class DevelopmentDataImpl implements Master {
	private String end;

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	@Override
	public Object Load() {
		return null;
	}

	
}
