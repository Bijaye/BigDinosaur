package org.bigdinosaur.core.database;

//Every method call is associated with certain context.The method is also accociated with certian service and service is also 
//associated with certain layer,so context to action is very important 
public abstract class BdEvent {
  
    public static final String NEWDATAADDED = "newdataadded";
    public static final String PROCESSINGCOMPLETE = "processingcomplete";
    abstract String getProgramId(String screenId);
     public abstract String getScreenId();
}