package org.bigdinosaur.core.database;

import java.util.List;

import com.base.bigdinosaur.core.EasyBase;

public interface BdAcl
{
  public abstract boolean isActionEnabled();
  void LoginRmi(Object c);
  void Authenticate();
  void Authorize();
  void CreateRemoteUserSystem();
  String getUserName();
  String getSessionid();
  public abstract boolean checkPrivilege(String programID) ;
  // secret logic check ,object can be any of paramter like programid and many more 
  public  abstract String getOperationType(BdAcl service, Object inputServiceDto);
  public String getClientComputerName();
  String getPerformaceframeId();
  String getPackageId();
  String getSecurityid();
  List<EasyBase> getSecurity();
  String getAgentId();
  String getProgramPid();
  String getScreenPid();
  String getMenuPid();
  String getModulePid();
  String getExecutionPid();
  List<EasyBase>getResultInforMap();
}
