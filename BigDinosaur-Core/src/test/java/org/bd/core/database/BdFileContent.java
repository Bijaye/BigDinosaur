package org.bd.core.database;

public class BdFileContent
{
String filecontent;
public String getFoldername()
{
  return foldername;
}

public String getFolderpath()
{
  return folderpath;
}

public void setFoldername(String foldername)
{
  this.foldername = foldername;
}

public void setFolderpath(String folderpath)
{
  this.folderpath = folderpath;
}

String foldername;
String folderpath;

public String getFilecontent()
{
  return filecontent;
}

public void setFilecontent(String filecontent)
{
  this.filecontent = filecontent;
}
}
