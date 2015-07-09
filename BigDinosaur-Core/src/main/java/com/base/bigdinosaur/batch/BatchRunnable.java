package com.base.bigdinosaur.batch;

public interface BatchRunnable {
    boolean execute();
    boolean executeMultipleRunnable();
    boolean executeService(String args[]);

}
