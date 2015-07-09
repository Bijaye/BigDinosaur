package com.base.bigdinosaur.core.adapter;

 
//Using inheritance for adapter pattern
public class IndicatorClassAdapterImpl extends Indicator implements IndicatorAdapter{
 
    @Override
    public ServiceIndicator getServiceStatusPoor() {
        return getServiceStatus();
    }
 
    @Override
    public ServiceIndicator getServiceStatusNormal() {
        ServiceIndicator v= getServiceStatus();
		return v;
       
    }
 
    @Override
    public ServiceIndicator getServiceStatusDown() {
        ServiceIndicator v= getServiceStatus();
		return v;
       
    }
     
   
 
}