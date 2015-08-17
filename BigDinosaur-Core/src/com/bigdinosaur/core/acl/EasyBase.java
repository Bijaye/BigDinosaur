package com.bigdinosaur.core.acl;

public interface EasyBase extends EasyCore {
	EasyBase getSecurityOrigin();
	EasyBase getSecurityLevel();
	EasyBase getSecurityHistory();

}
