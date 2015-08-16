package com.bigdinosaur.bigdata.accesspolicy;

public interface EasyBase extends EasyCore {
	EasyBase getSecurityOrigin();
	EasyBase getSecurityLevel();
	EasyBase getSecurityHistory();

}
