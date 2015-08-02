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

}
