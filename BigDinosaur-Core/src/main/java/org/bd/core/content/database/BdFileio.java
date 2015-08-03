package org.bd.core.content.database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BdFileio
{

  public String createFile(String location) throws IOException{
    
    File file = new File(location);
    
    if (file.createNewFile()){
      System.out.println("File is created!");
    }else{
      System.out.println("File already exists.");
    }
    return location;
    
  }
 public  void writeTableColumns(String databaselocation,String coumns) throws IOException{
    String content = coumns.toString();
    
    File file = new File(databaselocation);

   

    FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write(content);
    bw.close();

    System.out.println("Done");

  } 
  }
