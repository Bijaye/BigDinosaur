package org.bd.core.content.database;

public class DataBaseImpl implements Database
{
// it will create C://Databasename in file system 
  @Override
  public void createDatabase(String database)
  {
    
  }
// it will set the location of database .For example C://Databasename 
  @Override
  public void SetDatabaselocation(String databaselocation)
  {
    // TODO Auto-generated method stub
    
  }
// it will create table in location C://Databasename/databasemetadata.txt/likes.txt
  @Override
  public void createTableName(String tablename)
  {
    
  }
// it will add columns information in C://Databasename/databasemetadata.txt 
  //for example
  //User,idname,email, location ,date of birth,locationofusertextfile
  //Likes idname moviename,bookname,locationname,foodname,locationofliketextfile
  //Follow idname SteveJobs,WarrentBuffet,locationofusertextfile
  @Override
  public void createTableColumnsname(String tablename, String[] columns)
  {
    // TODO Auto-generated method stub
    
  }
  // if table name is likes then it need to return location C://Databasename/databasemetadata.txt/likes.txt
  @Override
  public String getLocationOfTable(String tablename)
  {
    return null;
  }

}
