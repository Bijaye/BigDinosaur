package com.bigdinosaur.base.content.operation;

import com.easy.base.ecm.information.InformationContainer;

public interface ContentOperation {
	void pull();
	void push();
	void commit();
	Branch CreateBranch();
	Tag Tag();
	InformationContainer ListHistoryInformationContainer();


}
