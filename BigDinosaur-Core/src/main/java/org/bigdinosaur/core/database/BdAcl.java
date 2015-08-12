package org.bigdinosaur.core.database;

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
}
