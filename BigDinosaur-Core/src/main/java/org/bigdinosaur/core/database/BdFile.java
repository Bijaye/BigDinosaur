package org.bigdinosaur.core.database;

import java.util.ArrayList;

public  class BdFile
{
  String fileinstance;
  String objectnstance;
String filename;
String filepath;
int  tableindex;
String dirlocation;
String desfoldername;
public  boolean isEndOfFile(){
  return false;
  
}
public  int getFileStart(){
  return tableindex;
  
}

public  long getRecordCount(){
  return tableindex;
  
}
public  long getRecordObjectRow(){
  return tableindex;
  
}
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
public String getObjectnstance()
{
  return objectnstance;
}
public String getFilepath()
{
  return filepath;
}
public int getTableindex()
{
  return tableindex;
}
public String getDirlocation()
{
  return dirlocation;
}
public void setObjectnstance(String objectnstance)
{
  this.objectnstance = objectnstance;
}
public void setFilepath(String filepath)
{
  this.filepath = filepath;
}
public String getDesfoldername()
{
  return desfoldername;
}
public void setDesfoldername(String desfoldername)
{
  this.desfoldername = desfoldername;
}
public void setTableindex(int tableindex)
{
  this.tableindex = tableindex;
}
public void setDirlocation(String dirlocation)
{
  this.dirlocation = dirlocation;
}


  

}
