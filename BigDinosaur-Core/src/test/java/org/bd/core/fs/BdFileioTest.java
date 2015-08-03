package org.bd.core.fs;

import java.io.IOException;

import org.bd.core.content.database.BdFileio;

public class BdFileioTest
{
  public static void main(String[] args) throws IOException
  {
//    writeMetadata();
    
//    test.writeTableColumns("D://databasename//metadata.txt", columns1);
    writeColumns(args);
  }
  static void writeColumns(String[] columns) throws IOException{
    BdFileio test=new  BdFileio();
    String coumns[]=new String[6];
    coumns[0]="user";
    coumns[1]="123";
    coumns[2]="abishkar_bhattarai@hotmail.com";
    coumns[3]="14 feb ";
    coumns[4]="D://databasename//user.txt";
  
    
    
    test.writeTable("D://databasename//user.txt", coumns);
    
  }

  private static void writeMetadata() throws IOException
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
    
    
    test.writeTableMetadata("D://databasename//metadata.txt", columns);
  }
}
