package com.bigdinosaur.base.batch.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class BatchUtils {
    private static ClassPathXmlApplicationContext batchCtx;

    private BatchUtils() {
    }

    public static ClassPathXmlApplicationContext getBatchCtx() {
        return batchCtx;
    }

    public static void setBatchCtx(ClassPathXmlApplicationContext batchCtx) {
        batchCtx = batchCtx;
    }

    public static Object getBean(String beanName) {
        return batchCtx.getBean(beanName);
    }

    
}
