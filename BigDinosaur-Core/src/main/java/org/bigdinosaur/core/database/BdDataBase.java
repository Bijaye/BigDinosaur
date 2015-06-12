package org.bigdinosaur.core.database;

import java.util.ArrayList;

public class BdDataBase
{
  String databasename;
  String databasepath;
  ArrayList<TableNode> tablenode=new ArrayList<TableNode>();
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
  String getResultBaseFromBdQuery(BdQuery query){
    return query.getBasebdquery();
    
  }
  String getResultMiddleFromBdQuery(BdQuery query){
    return query.getBasebdquery();
    
  }
  String getResultendFromBdQuery(BdQuery query){
    return query.getBasebdquery();
    
  }

}
