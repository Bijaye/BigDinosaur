package com.bd.core.documentmanagement;


public class Folder
{
  String Foldername;
  byte[] bytedata;
  public Folder(String Foldername, byte[] bytedata)
  {
    this.Foldername = Foldername;
    this.bytedata = bytedata;
  }
  Folder Foldernext;
  
  
}