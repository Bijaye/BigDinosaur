package com.bigdinosaur.config;



public interface Configurable {

  void setConf(BdConfiguration conf);

  BdConfiguration getConf();
}
