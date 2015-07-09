


package com.base.bigdinosaur.batch;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bigdinosaur.base.batch.service.BaseBatchService;
import com.easy.base.batch.util.BatchUtils;

public class BatchRunner implements BatchRunnable {

    public BatchRunner() {

    }

    
    public boolean executeService(String args[]) {
        if (!checkArgs(args)) {
            System.exit(1);
        }
        int result = executeBatchService(args);
        if (result == 0) {

        }

        else if (result == -1) {

        }
        return false;

    }

    protected void setApplicationContext(String contextPath) {
        ClassPathXmlApplicationContext batchCtx = new ClassPathXmlApplicationContext(contextPath);
        BatchUtils.setBatchCtx(batchCtx);
    }

    protected boolean checkArgs(String args[]) {
        if (args == null || args.length < 2) {

            return false;
        }
        try {
            if (!args[0].trim().isEmpty()) {
                setApplicationContext(args[0].trim());
            }
        } catch (Exception e) {
            return false;
        }
        jobId = args[1].trim();
        try {
            service = (BaseBatchService) BatchUtils.getBean(jobId);
        } catch (Exception e) {

            return false;
        }
        return true;
    }

    protected int executeBatchService(String args[]) {
        int result = 0;
        try {
            result = service.doExecute(args);
        } catch (Exception e) {

        }
        return result;
    }

    protected Logger logger;
    protected BaseBatchService service;
    protected String jobId;
    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public boolean executeMultipleRunnable() {
        return false;
    }

}
