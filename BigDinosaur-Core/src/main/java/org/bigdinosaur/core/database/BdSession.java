package org.bigdinosaur.core.database;

public interface BdSession{
  

BdSession getSessionInfo();
String getLanguage();
BdSession getClusterSession();
BdSession getAllJvmSessison();
BdSession getSingleJvmSession();
BdSession getSessionInfoEasybatch();
BdSession getSessionInfoStandAloneApp();
BdSession getSessionInfoDistributed();
BdSession getSessionInfoWeb();

void deleteLogInSuccess();

  void deleteSuccessDBOnly();

  void resetContext();
  void log();

}
