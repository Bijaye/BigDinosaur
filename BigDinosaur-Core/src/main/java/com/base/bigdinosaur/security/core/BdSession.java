package com.base.bigdinosaur.security.core;

public interface BdSession {
  BdSession getSessionInfo();
	  String getLanguage();
	  BdSession getClusterSession();
	  BdSession getAllJvmSessison();
	  BdSession getSingleJvmSession();
	  BdSession getSessionInfoEasybatch();
	  BdSession getSessionInfoStandAloneApp();
	  BdSession getSessionInfoDistributed();
	  BdSession getSessionInfoWeb();
	    
	  
}


