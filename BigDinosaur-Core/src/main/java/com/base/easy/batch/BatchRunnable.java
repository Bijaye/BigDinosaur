package com.base.easy.batch;

public interface BatchRunnable {
    boolean execute();
    boolean executeMultipleRunnable();
    boolean executeService(String args[]);

}
