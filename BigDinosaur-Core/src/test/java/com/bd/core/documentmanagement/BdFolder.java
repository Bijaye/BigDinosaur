package com.bd.core.documentmanagement;


public class BdFolder
{
  String Foldername;
  byte[] bytedata;
  public BdFolder(String Foldername, byte[] bytedata)
  {
    this.Foldername = Foldername;
    this.bytedata = bytedata;
  }
  BdFolder Foldernext;
  
  
}