package org.bigdinosaur.core.database;

public interface BdTask
{
  boolean execute();
  boolean executeMultipleRunnable();
  boolean executeService(String args[]);
}
