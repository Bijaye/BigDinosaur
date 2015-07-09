package com.bigdinosaur.base.web.ui.annotation;



import java.lang.annotation.Annotation;

public interface DateNotBlank
    extends Annotation
{

    public abstract String errorCode();

    public abstract String message();

    public abstract String args();

    public abstract String applyIf();

    public abstract String[] contexts();
}

