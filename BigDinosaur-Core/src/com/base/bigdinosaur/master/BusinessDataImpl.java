package com.base.bigdinosaur.master;

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
	public DevelopmentData Load() {
	  // set in DevelopmentData and return it after development data is set 
	  // big dinosaur does not uses database to store 
	  // it is assumbed till now it exists in memory 
	//  DevelopmentData data=new IDevelopmentData();
		return null;
	}

}
