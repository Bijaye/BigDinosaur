package com.base.bigdinosaur.batch;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.security.auth.login.Configuration;

public class ConfInfo {

  protected String path;
  protected ArrayList<ConfEntryInfo> property;

  public ConfInfo() {
  }

  public ConfInfo(Job job) throws IOException {

   // Config from reading property file 

  }

  public ArrayList<ConfEntryInfo> getProperties() {
    return this.property;
  }

  public String getPath() {
    return this.path;
  }

}
