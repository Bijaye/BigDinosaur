package org.bigdinosaur.core.database;

public class BdTableNode
{
String tablename;
BdFile filename;
public String getTablename()
{
  return tablename;
}
public BdFile getFilename()
{
  return filename;
}
public void setTablename(String tablename)
{
  this.tablename = tablename;
}
public void setFilename(BdFile filename)
{
  this.filename = filename;
}
}
