package com.base.bigdinosaur.security.core;



public interface BdSecurity {
	  public abstract boolean isActionEnabled();
	  void LoginRmi(Object c);
	  void Authenticate();
	  void Authorize();
	  void CreateRemoteUserSystem();
	  String getUserName();
	  String getSessionid();
	  Object getGroupInfo();
	  Object getSubRoleInfo();
	  Object getRoleInfo();
	  Object getSubGroupInfo();
	  Object getTeamInfo();
	  Object getSubTeamInfo();
	  Object getUserInfo();
	  Object getWorkstationInfo();
	  BdSession getSessionInfoEasybatch();
	  BdSession getSessionInfoStandAloneApp();
	  BdSession getSessionInfoDistributed();
	  BdSession getSessionInfoWeb();

}
