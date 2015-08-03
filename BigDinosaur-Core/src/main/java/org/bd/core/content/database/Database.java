package org.bd.core.content.database;

public interface Database
{
 void createDatabase(String database);
 void SetDatabaselocation(String databaselocation);
 void createTableName(String tablename);
 void createTableColumnsname(String tablename,String[] columns);
String  getLocationOfTable(String tablename);
}
