package com.bigdinosaur.base.core.bpmimpl;

import com.bigdinosaur.base.core.bpm.EasyServiceBridge;

public abstract class EasyServiceBridgeActivi implements EasyServiceBridge{
	abstract void  getBridgeListener();
	abstract void getBridgeEvent();
	String getDefault(){
		return "defaulteasybridge";
	}
	
	

}
