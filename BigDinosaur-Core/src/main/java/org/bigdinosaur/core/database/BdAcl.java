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
}
