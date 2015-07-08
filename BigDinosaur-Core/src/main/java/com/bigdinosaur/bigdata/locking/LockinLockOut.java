package com.bigdinosaur.bigdata.locking;


public interface LockinLockOut
{
  public  boolean isCheckedOut(Object object) throws Exception;
  public  boolean isCheckedIn(Object object) throws Exception;


}