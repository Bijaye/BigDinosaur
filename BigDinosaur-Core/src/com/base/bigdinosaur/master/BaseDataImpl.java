package com.base.bigdinosaur.master;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BaseDataImpl")
public class BaseDataImpl implements Master{
	private String bufferSize;

	public String getStart() {
		return bufferSize;
	}

	public void setStart(String bufferSize) {
		this.bufferSize = bufferSize;
	}

	@Override
	public DevelopmentData Load() {
	  // set in DevelopmentData and return it after development data is set 
	  // big dinosaur does not uses database to store 
	  // it is assumbed till now it exists in memory 
	//  DevelopmentData data=new IDevelopmentData();
	  
	  
	  // validate configuration setting .Check right value is loaded 
	  // increase the configuration parameter  from master.xml files
	  // use at least 15% configuration used by hadoop 
		return null;
	}

}
