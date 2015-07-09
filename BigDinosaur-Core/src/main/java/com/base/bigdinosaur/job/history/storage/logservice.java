package com.base.bigdinosaur.job.history.storage;

public interface logservice {
    void deleteLogInSuccess();

    void deleteSuccessDBOnly();

    void resetContext();
    void log();

}
