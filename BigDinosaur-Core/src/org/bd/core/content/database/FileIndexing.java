package org.bd.core.content.database;

public class FileIndexing
{
  String key;
  public String getKey()
  {
    return key;
  }

  public void setKey(String key)
  {
    this.key = key;
  }

  String indexlocation;

  public String getIndexlocation()
  {
    return indexlocation;
  }

  public void setIndexlocation(String indexlocation)
  {
    this.indexlocation = indexlocation;
  }
  public String toString() {
   String concat= key +" "+indexlocation;
   return concat;
    
  }

}
