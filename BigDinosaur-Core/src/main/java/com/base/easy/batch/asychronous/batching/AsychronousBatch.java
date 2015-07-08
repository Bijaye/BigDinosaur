package com.base.easy.batch.asychronous.batching;

public interface AsychronousBatch {
	// Every Batch id share the common Attribute.For example 
	//CaseI framework need to know Batch Task
	//CaseII framework need to know in which location batch need to be executed .It is in the sense that for unknown host environment preparation for agent connection can be done 
	//Case III:Some batch require call to external web service also if one platform data has some interconnection with another platform data running in different host 
	void addBatchTask();
	void addLocation();
	void addWebServiceOfBatchExecution();
	void isSameServer();
	void isDiffrentServer();
	void getLogOfBatchSucess();
	void getLogOfBatchFailure();
	void getNotifiedOfBatchEnd();
	boolean getMonitorStatus();

}
