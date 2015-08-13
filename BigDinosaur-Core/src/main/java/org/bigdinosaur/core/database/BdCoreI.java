package org.bigdinosaur.core.database;

public class BdCoreI implements BdCore
{
private String slots;//it can be property or action 
//for example pigeonhole=Property or pigeonhole=action;
private String propertyname;
//propertyname=file;
private String displayname;
//displayname=file;
private String propertydescription;
//propertydescription=static or dynami
private String type;
//what type of object it is 

private String flags;
//read or write or read write what it is 
  @Override
  public boolean canRead(Object o)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean canWrite(Object o)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Object getAsBdFile(Object o)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Object getAsBdTableNode(Object o)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Object getAsBdQuery(Object o)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Object getAsBdFileRow(Object o)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Object AddOnUniversalMap(Object key, Object value)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BdCore getBdCore()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Boid getBoird()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BdSpace getBdSpace()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BdSession getBdSession()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BdAcl getBdAcl()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getModuleId()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void ConstructObjectAccess()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void ConstructObjectBpm()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void ConstructObjectEcm()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void ConstructObjectBatch()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void BridgeBpm()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void BridgeUI()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void Process()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void ProcessState()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void State()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void WorkFlow()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void WorkFlowState()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void AccessLogInterceptor()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Object ConstructObjectIterateObjectGrowth(Object growth)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Class ConstructObjectIterateClassGrowth(Class growth)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void getBusinessType()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void getBusiness()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void getBusinessPackages(String businesstype)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void getModulesList(String businesspackage)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void getModule(String programid)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void BdDynamicObject()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void BdMaster()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void BdmasterLinkSlaveStation()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void BdPlaceholderEvent()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void BdSlave()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void BdStaticObject()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void BdThreeWayCommunication()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void BdTwoWayCommunication()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void BigDinosaurObject()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void CommonObjectModel()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void InsfractureProvider()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void MainStationControlEngine()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void ObjectInformationResolutionDescriptor()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void StationJVM()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void TimerBindToClusterComponent()
  {
    // TODO Auto-generated method stub
    
  }

}
