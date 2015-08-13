package com.base.bigdinosaur.batch;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("MasteraccessImpl")
public class MasteraccessImpl implements Master{
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public Object Load() {
		return null;
	}

	

}
