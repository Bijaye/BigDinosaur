package org.bigdinosaur.core.database;



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
	  Object runUiSourcecomponentCheckIntercpetor();
	  Object  runAutheticationCheckInterceptor();
	  Object runAuthorizationCheckInterceptor();
	  Object runFieldCacheInterceptor();
	  Object runLoginCheckInterceptor();
	  Object runMenuCheckIntercpetor();
	  Object runPrivilegeCheckInterceptor();
	  Object runRequestInterceptor();
	  Object runTableCheckIntercpetor();
	  Object getRoles();
	  Object getTeam();
	  Object getUser();
	  Object getGroup();
	  Object getEcmObject();

}
