package com.base.bigdinosaur.master;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("MasteraccessImpl")
public class MasteraccessImpl implements Master{
	private String blockSize;

	public String getRole() {
		return blockSize;
	}

	public void setRole(String blockSize) {
		this.blockSize = blockSize;
	}

	@Override
	public Object Load() {
		return null;
	}

	

}
