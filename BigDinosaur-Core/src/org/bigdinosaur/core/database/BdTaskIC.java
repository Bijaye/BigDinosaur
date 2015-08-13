package org.bigdinosaur.core.database;



import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


//Note:Need to convert spring equivalent logic to BB equivalent 
public abstract class BdTaskIC extends BdTaskI
{

            public BdTaskIC()
            {
            }

            public int doExecute(String args[])
            {
                int result = 0;
       initialize(args);
       try
       {
           result = execute(args);
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       return result;
   }

   private void initialize(String args[])
   {
       jobId = args[1].trim();
       RequestContext reqCtx = (RequestContext)BatchUtils.getBean("nIRequestContext");
       reqCtx.setBatchmoduleid(jobId);
   }

   public void beginTransaction()
   {
       DefaultTransactionDefinition txDef = new DefaultTransactionDefinition();
       txDef.setPropagationBehavior(0);
       txStatus = txManager.getTransaction(txDef);
       logger.info("Transaction started.");
   }

   public void commitTransaction()
   {
       if(txStatus != null)
       {
           if(!txStatus.isCompleted())
               txManager.commit(txStatus);
       } else
       {
           logger.error("Transaction is not started.");
           System.exit(1);
       }
   }

   public void rollbackTransaction()
   {
       if(txStatus != null)
       {
           if(!txStatus.isCompleted())
               txManager.rollback(txStatus);
       } else
       {
           logger.error("Transaction is not started.");
       }
   }

   public PlatformTransactionManager getTxManager()
   {
       return txManager;
   }

   public void setTxManager(PlatformTransactionManager txManager)
   {
       this.txManager = txManager;
   }

            public abstract int execute(String as[]);

            private PlatformTransactionManager txManager;
            private TransactionStatus txStatus;
            private String jobId;

}


