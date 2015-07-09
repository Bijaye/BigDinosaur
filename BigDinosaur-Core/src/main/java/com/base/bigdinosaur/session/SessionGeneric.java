package com.base.bigdinosaur.session;

public interface SessionGeneric {
	Session getSessionInfoEasybatch();
	Session getSessionInfoStandAloneApp();
	Session getSessionInfoDistributed();
	Session getSessionInfoWeb();

}
