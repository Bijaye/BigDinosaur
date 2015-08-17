package com.base.bigdinosaur.utility;


public final class BatchUtils {
    private static Object batchCtx;

    private BatchUtils() {
    }

    public static Object getBatchCtx() {
        return batchCtx;
    }

    public static void setBatchCtx(Object batchCtx) {
        batchCtx = batchCtx;
    }

    public static Object getBean(String beanName) {
        return beanName;
    }

    
}
