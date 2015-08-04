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
  
  public Folder getFoldernext()
  {
    return Foldernext;
  }
  public void setFoldernext(Folder Foldernext)
  {
    this.Foldernext = Foldernext;
  }
  Folder getNewFolder(String Foldername,byte[] bytedata){
    return new Folder(Foldername,bytedata);
    
  }
}