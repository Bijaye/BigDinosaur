package com.easy.base.core.bpmimpl;

import com.easy.base.core.bpm.EasyServiceBridge;

public abstract class EasyServiceBridgeActivi implements EasyServiceBridge{
	abstract void  getBridgeListener();
	abstract void getBridgeEvent();
	String getDefault(){
		return "defaulteasybridge";
	}
	
	

}
