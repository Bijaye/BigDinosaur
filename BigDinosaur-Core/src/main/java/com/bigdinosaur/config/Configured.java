package com.bigdinosaur.config;




public class Configured implements Configurable {

  private Configuration conf;

  public Configured() {
    this(null);
  }
  
  public Configured(Configuration conf) {
    setConf(conf);
  }

  public void setConf(Configuration conf) {
    this.conf = conf;
  }

  public Configuration getConf() {
    return conf;
  }

}
