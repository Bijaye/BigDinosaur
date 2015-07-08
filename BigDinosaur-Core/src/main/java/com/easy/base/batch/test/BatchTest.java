
package com.easy.base.batch.test;

import com.base.easy.batch.BatchRunner;



public class BatchTest {

    public static void main(String[] args) {
        String[] arg = new String[14];
         arg[0] = "applicationContext.xml";
         arg[1] = "moduleid";
         BatchRunner test=new BatchRunner();
         test.executeService(arg);
    }
}
