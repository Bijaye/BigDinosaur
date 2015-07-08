package com.bigdinosaur.cluster.space;

import java.util.HashMap;
import java.util.Map;

import com.bigdinosaur.cluster.host.Bdhost;

public class ClusterSpace
{
  private Map bdmap=new HashMap<>();
  public  ClusterSpace getClusterSpace()
  {
    return null;
  }
 
  public boolean isClusterSpaceReadonly()
  {
    return false;
   
  }
  public boolean isRunning()
  {
    return false;
   
  }
  
  public void stop()
  {
  
   
  }

  public void start()
  {
  
   
  }
  //callback after cluster is started
  public void clusterstarted()
  {
  
   
  }
  Bdhost getHost(){
    return null;
    
  }
}
