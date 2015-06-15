package org.bigdinosaur.core.database;

import java.util.ArrayList;

public class BdTableNode
{
String tablename;
String filepath;
int tableindex;
BdFile filename;
ArrayList<BdFileNode> readFile(){
  ArrayList<BdFileNode>listoffiles =new ArrayList<BdFileNode>();
  return listoffiles;
}
BdFileNode createBdFileObject(){
  // read from .data that exists on some directory
  // Create BdFileNode object by reading every row .
  //Every row represent BdFileNode
  BdFileNode filenode=new BdFileNode();
  return filenode;
  
  
}
public String getTablename()
{
  return tablename;
}
public BdFile getFilename()
{
  return filename;
}
public void setTablename(String tablename)
{
  this.tablename = tablename;
}
public void setFilename(BdFile filename)
{
  this.filename = filename;
}
}
