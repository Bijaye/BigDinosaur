package org.bigdinosaur.core.database;

import java.util.ArrayList;

public class BdFile
{
String filename;
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
}
