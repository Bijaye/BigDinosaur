package com.bigdinosaur.base.core.bpm;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.impl.interceptor.CommandInterceptor;
import org.activiti.spring.SpringProcessEngineConfiguration;

public class EasyProcessEngineConfiguration extends SpringProcessEngineConfiguration implements EasyEngineServices{
	private EasyServiceBridge easyservice; 
	
	public EasyProcessEngineConfiguration() {
		super();
	
	}
	protected  CommandInterceptor createTransactionInterceptor(){
		return commandInvoker;
		
	}
	public ProcessEngine buildProcessEngine() {
		ProcessEngine processEngine = super.buildProcessEngine();
		easyservice.getBridge();
		return processEngine;
		
	}
	@Override
	public EasyService getEasyService() {
		return easyservice;
	}
	
	public void setEasyservice(EasyServiceBridge easyservice) {
		this.easyservice = easyservice;
	}
}
