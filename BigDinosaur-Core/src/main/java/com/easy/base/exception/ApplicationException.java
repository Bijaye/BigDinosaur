package com.easy.base.exception;





public class ApplicationException extends Exception
{

            public ApplicationException(String messageId, Throwable e)
            {
       super(e);
       this.messageId = messageId;
            }

            public ApplicationException(String messageId)
            {
       this.messageId = messageId;
   }

   public String getMessageId()
   {
       return messageId;
   }

   public void setMessageId(String messageId)
   {
       this.messageId = messageId;
   }

            private static final long serialVersionUID = -7569477165589642176L;
            private String messageId;
}


