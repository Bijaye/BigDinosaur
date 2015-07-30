package org.bd.core.database;

public class BdUser
{
public int getId()
  {
    return id;
  }
  public String getName()
  {
    return name;
  }
  public String getLocation()
  {
    return location;
  }
  public void setId(int id)
  {
    this.id = id;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public void setLocation(String location)
  {
    this.location = location;
  }
private int id;
public BdUser(int id, String name, String location)
{
  super();
  this.id = id;
  this.name = name;
  this.location = location;
}
private String name;
private String location;

@Override
public int hashCode() {
    return this.getId();
}

}
