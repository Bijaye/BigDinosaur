package com.base.bigdinosaur.batch;


import java.util.ArrayList;



public class JobInfo {

  protected long startTime;
  protected long finishTime;
  protected String id;
  protected String name;
  protected String queue;
  protected String user;
  protected String state;
  protected int mapsTotal;
  protected int mapsCompleted;
  protected int reducesTotal;
  protected int reducesCompleted;
  protected Boolean uberized;
  protected String diagnostics;
  protected Long avgMapTime;
  protected Long avgReduceTime;
  protected Long avgShuffleTime;
  protected Long avgMergeTime;
  protected Integer failedReduceAttempts;
  protected Integer killedReduceAttempts;
  protected Integer successfulReduceAttempts;
  protected Integer failedMapAttempts;
  protected Integer killedMapAttempts;
  protected Integer successfulMapAttempts;
  protected ArrayList<ConfEntryInfo> acls;

 
  protected int numMaps;
  
  protected int numReduces;

  public JobInfo() {
  }

  public JobInfo(Job job) {
   
    

    this.acls = new ArrayList<ConfEntryInfo>();
    
   
      avgMapTime = 0l;
      avgReduceTime = 0l;
      avgShuffleTime = 0l;
      avgMergeTime = 0l;
      failedReduceAttempts = 0;
      killedReduceAttempts = 0;
      successfulReduceAttempts = 0;
      failedMapAttempts = 0;
      killedMapAttempts = 0;
      successfulMapAttempts = 0;
      this.diagnostics = "";
        StringBuffer b = new StringBuffer();
        this.diagnostics = b.toString();
      }


      

  public long getNumMaps() {
    return numMaps;
  }

  public long getNumReduces() {
    return numReduces;
  }

  public Long getAvgMapTime() {
    return avgMapTime;
  }

  public Long getAvgReduceTime() {
    return avgReduceTime;
  }

  public Long getAvgShuffleTime() {
    return avgShuffleTime;
  }

  public Long getAvgMergeTime() {
    return avgMergeTime;
  }

  public Integer getFailedReduceAttempts() {
    return failedReduceAttempts;
  }

  public Integer getKilledReduceAttempts() {
    return killedReduceAttempts;
  }

  public Integer getSuccessfulReduceAttempts() {
    return successfulReduceAttempts;
  }

  public Integer getFailedMapAttempts() {
    return failedMapAttempts;
  }

  public Integer getKilledMapAttempts() {
    return killedMapAttempts;
  }

  public Integer getSuccessfulMapAttempts() {
    return successfulMapAttempts;
  }

  public ArrayList<ConfEntryInfo> getAcls() {
    return acls;
  }

  public int getReducesCompleted() {
    return this.reducesCompleted;
  }

  public int getReducesTotal() {
    return this.reducesTotal;
  }

  public int getMapsCompleted() {
    return this.mapsCompleted;
  }

  public int getMapsTotal() {
    return this.mapsTotal;
  }

  public String getState() {
    return this.state;
  }

  public String getUserName() {
    return this.user;
  }

  public String getName() {
    return this.name;
  }

  public String getQueueName() {
    return this.queue;
  }

  public String getId() {
    return this.id;
  }

  public long getStartTime() {
    return this.startTime;
  }

  public long getFinishTime() {
    return this.finishTime;
  }

  public Boolean isUber() {
    return this.uberized;
  }

  public String getDiagnostics() {
    return this.diagnostics;
  }

  

}
