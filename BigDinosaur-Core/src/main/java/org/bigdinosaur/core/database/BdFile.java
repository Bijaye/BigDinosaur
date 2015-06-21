package org.bigdinosaur.core.database;

import java.util.ArrayList;

public abstract class BdFile
{
  String fileinstance;
  String objectnstance;
String filename;
String filepath;
int  tableindex;
public abstract boolean isEndOfFile();
public abstract int getFileStart();

public abstract long getRecordCount();
public abstract long getRecordObjectRow();
public String getFilename()
{
  return filename;
}
public ArrayList<BdFileRow> getFilerow()
{
  return filerow;
}
public void setFilename(String filename)
{
  this.filename = filename;
}
public void setFilerow(ArrayList<BdFileRow> filerow)
{
  this.filerow = filerow;
}
ArrayList<BdFileRow> filerow=new ArrayList<BdFileRow>();
public String getFileinstance()
{
  return fileinstance;
}
public void setFileinstance(String fileinstance)
{
  this.fileinstance = fileinstance;
}


  

}
