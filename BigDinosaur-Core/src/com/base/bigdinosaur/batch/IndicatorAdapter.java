package com.base.bigdinosaur.batch;

public interface IndicatorAdapter {
 
    public ServiceIndicator getServiceStatusPoor();
         
    public ServiceIndicator getServiceStatusNormal();
     
    public ServiceIndicator getServiceStatusDown();
}