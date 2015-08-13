package org.bigdinosaur.core.database;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public class BdAclI implements BdAcl
{

  @Override
  public boolean isActionEnabled()
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void LoginRmi(Object c)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void Authenticate()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void Authorize()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void CreateRemoteUserSystem()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public String getUserName()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getSessionid()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean checkPrivilege(String programID)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public String getOperationType(BdAcl service, Object inputServiceDto)
  {
    // TODO Auto-generated method stub
    return null;
  }

  public String getClientComputerName() {
 String computerName = null;
 try {
   computerName = InetAddress.getLocalHost().getHostName();
   if (computerName != null) {
     computerName = computerName.toUpperCase();
   }
 } catch (UnknownHostException e) {
 }
 return computerName;
}

  @Override
  public String getPerformaceframeId()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getPackageId()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getSecurityid()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<BdAcl> getSecurity()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getAgentId()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getProgramPid()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getScreenPid()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getMenuPid()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getModulePid()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getExecutionPid()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<BdAcl> getResultInforMap()
  {
    // TODO Auto-generated method stub
    return null;
  }

}
