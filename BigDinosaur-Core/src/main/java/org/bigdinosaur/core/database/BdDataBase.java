package org.bigdinosaur.core.database;

import java.util.ArrayList;

public class BdDataBase
{
  String databasename;
public String getDatabasename()
  {
    return databasename;
  }
  public String getDatabasepath()
  {
    return databasepath;
  }
  public ArrayList<TableNode> getTablenode()
  {
    return tablenode;
  }
  public void setDatabasename(String databasename)
  {
    this.databasename = databasename;
  }
  public void setDatabasepath(String databasepath)
  {
    this.databasepath = databasepath;
  }
  public void setTablenode(ArrayList<TableNode> tablenode)
  {
    this.tablenode = tablenode;
  }
String databasepath;
ArrayList<TableNode> tablenode=new ArrayList<TableNode>();
}
