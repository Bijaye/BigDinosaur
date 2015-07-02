package com.bigdinosaur.core.io;

import java.util.ArrayList;
import java.util.List;

public class BdRead
{
List<BdRead> readdata=new ArrayList<BdRead>();
int i;
String mapstring;
public String getMapstring()
{
  return mapstring;
}
public void setMapstring(String mapstring)
{
  this.mapstring = mapstring;
}
public int getI()
{
  return i;
}
public void setI(int i)
{
  this.i = i;
}
public List<BdRead> getReaddata()
{
  return readdata;
}
public void setReaddata(List<BdRead> readdata)
{
  this.readdata = readdata;
}
}
