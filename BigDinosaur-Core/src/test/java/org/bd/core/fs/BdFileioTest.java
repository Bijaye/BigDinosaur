package org.bd.core.fs;

import java.io.IOException;

import org.bd.core.content.database.BdFileio;

public class BdFileioTest
{
  public static void main(String[] args) throws IOException
  {
    BdFileio test=new  BdFileio();
    test.createFile("D://databasename//bigdinosaur");
    test.createFile("D://databasename//user");
    test.createFile("D://databasename//likes");
    test.createFile("D://databasename//follow");
    test.createFile("D://databasename//metadata.txt");
//    String  columns=new  String("user,idname,email, location ,date of birth,locationofusertextfile\n");
//    String  columns1=new  String("likes idname moviename,bookname,locationname,foodname,locationofliketextfile\n");
    
    
    
    String  columns=new  String("follow idname SteveJobs,WarrentBuffet,locationofusertextfile\n");
    
    
    test.writeTableColumns("D://databasename//metadata.txt", columns);
//    test.writeTableColumns("D://databasename//metadata.txt", columns1);
  }
}
