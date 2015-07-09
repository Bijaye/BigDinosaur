package com.base.bigdinosaur.core.job;



public class ConfEntryInfo {

  protected String name;
  protected String value;
  protected String[] source;

  public ConfEntryInfo() {
  }

  public ConfEntryInfo(String key, String value) {
    this(key, value, null);
  }
  
  public ConfEntryInfo(String key, String value, String[] source) {
    this.name = key;
    this.value = value;
    this.source = source;
  }

  public String getName() {
    return this.name;
  }

  public String getValue() {
    return this.value;
  }
  
  public String[] getSource() {
    return source;
  }
}
