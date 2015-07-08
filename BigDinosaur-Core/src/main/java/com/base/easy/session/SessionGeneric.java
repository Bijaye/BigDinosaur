package com.base.easy.session;

public interface SessionGeneric {
	Session getSessionInfoEasybatch();
	Session getSessionInfoStandAloneApp();
	Session getSessionInfoDistributed();
	Session getSessionInfoWeb();

}
