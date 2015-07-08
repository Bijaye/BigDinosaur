package com.base.easy.core.adapter;

public class IndicatorObjectAdapterImpl implements IndicatorAdapter{
 
    //Using Composition for adapter pattern
    private Indicator indicator = new Indicator();
     
    @Override
    public ServiceIndicator getServiceStatusPoor() {
        return indicator.getServiceStatus();
    }
 
    @Override
    public ServiceIndicator getServiceStatusNormal() {
        ServiceIndicator v= indicator.getServiceStatus();
		return v;
       
    }
 
    @Override
    public ServiceIndicator getServiceStatusDown() {
        ServiceIndicator v= indicator.getServiceStatus();
		return v;
        
    }
     
   
}