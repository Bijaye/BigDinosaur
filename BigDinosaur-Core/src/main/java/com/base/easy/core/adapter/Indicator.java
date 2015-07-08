package com.base.easy.core.adapter;

 
public class Indicator {
 
    public ServiceIndicator getServiceStatus(){
    	// 120 is replaced with dynamic parameter as framework grows on 
        return new ServiceIndicator(120);
    }
}