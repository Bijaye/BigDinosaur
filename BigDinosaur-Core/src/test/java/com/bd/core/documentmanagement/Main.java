package com.bd.core.documentmanagement;


import java.io.IOException;
import java.util.ArrayList;

public class Main
{
  public static void main(String[] args) throws IOException
  {
    ArrayList<String> listoffilesname=new ArrayList<String>();
    
    
    
    listoffilesname.add("D://database//database.txt");
    listoffilesname.add("D://database//user//likes//follow//follow.txt");
    listoffilesname.add("D://database//user//likes//likes.txt");
    listoffilesname.add("D://database//user//user.txt");
    listoffilesname.add("D://database//fileindex//fileindex.txt");
   
    FolderImpl impl=new FolderImpl();
    impl.getListOfFilesLineage(listoffilesname);
   
  
    
   
    
   
      
    
  }
}
