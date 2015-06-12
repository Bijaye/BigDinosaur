package org.bigdinosaur.core.database;

import java.util.ArrayList;

public class BdDataBase
{
  String databasename;
  String databasepath;
  ArrayList<BdTableNode> tablenode=new ArrayList<BdTableNode>();
public String getDatabasename()
  {
    return databasename;
  }
  public String getDatabasepath()
  {
    return databasepath;
  }
  public ArrayList<BdTableNode> getTablenode()
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
  public void setTablenode(ArrayList<BdTableNode> tablenode)
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
