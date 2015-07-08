package com.base.easy.job.history.storage;

public interface logservice {
    void deleteLogInSuccess();

    void deleteSuccessDBOnly();

    void resetContext();
    void log();

}
