package com.base.bigdinosaur.master;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("DevelopmentDataImpl")
public class DevelopmentDataImpl implements Master {
	private String replication;

	public String getEnd() {
		return replication;
	}

	public void setEnd(String replication) {
		this.replication = replication;
	}

	@Override
	public Object Load() {
		return null;
	}

	
}
