package com.bigdinosaur.config;




public class Configured implements Configurable {

  private BdConfiguration conf;

  public Configured() {
    this(null);
  }
  
  public Configured(BdConfiguration conf) {
    setConf(conf);
  }

  public void setConf(BdConfiguration conf) {
    this.conf = conf;
  }

  public BdConfiguration getConf() {
    return conf;
  }

}
