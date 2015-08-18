package org.bigdinosaur.core.database;


import java.util.logging.Logger;

import com.bigdinosaur.base.service.BaseBatchService;


public class BdTaskI implements BdTask {

    public BdTaskI() {

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
//        ClassPathXmlApplicationContext batchCtx = new ClassPathXmlApplicationContext(contextPath);
//        BatchUtils.setBatchCtx(batchCtx);
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
//            service = (BaseBatchService) BatchUtils.getBean(jobId);
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


    @Override
    public boolean executeAgentControllerExternalBusinessprocess()
    {
      // TODO Auto-generated method stub
      return false;
    }


    @Override
    public boolean AgentControllerInternalBusinessprocess()
    {
      // TODO Auto-generated method stub
      return false;
    }


    @Override
    public boolean LockingExternal()
    {
      // TODO Auto-generated method stub
      return false;
    }


    @Override
    public boolean LockingInternal()
    {
      // TODO Auto-generated method stub
      return false;
    }

}
