package com.easy.base.web.ui.annotation;

import java.lang.annotation.Annotation;

public interface NotBlank
    extends Annotation
{

    public abstract String errorCode();

    public abstract String message();

    public abstract String args();

    public abstract String applyIf();

    public abstract String[] contexts();
}


/*
	DECOMPILATION REPORT

	Decompiled from: C:\tomcatA\webapps\kailas-server\WEB-INF\lib\kailas-server-framework-1.2.2.jar
	Total time: 15 ms
	Jad reported messages/errors:
	Exit status: 0
	Caught exceptions:
*/