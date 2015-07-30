package org.bd.core.database;

import java.io.FileOutputStream;
import java.io.IOException;
// there can be flexibility on how the user want to save data 
// User can save data in two ways 
// D//movies/movie1.mp3,movie2.mp3,movie3.mp3
//D//movies/Hindi/Oldmovie/movie1.mp3
//D//movies/Hindi/newmovie/movie2.mp3
import java.util.ArrayList;

//First create database folder-it is database name 
//create table folder-e.g company table ,user table ,Likes table,Follow table 
// Insert 

public class BdWriteFile
{

 void  write(String filepath,String webfilecontenet) throws IOException{
 
   byte[] dataToWrite = webfilecontenet.getBytes();

    
    FileOutputStream out = new FileOutputStream(filepath);
    out.write(dataToWrite);
    out.close();
  }
 public static void main(String[] args) throws IOException
{
   BdWriteFile write =new BdWriteFile();
//   String webfilecontenet="abc company ,pokhara ";
//   write.write("D://database/company.txt", webfilecontenet);
   write.search("", "", "", "");
   
   
   
   // look up session
   // if session is not expired retrive from cache 
   // if session is expired then search from database with username 
   
   
  
 String webfilecontenet="abishkar billgates ,larypage ";
 String filename="follow";
 
// write.write("D://database//user//follow//likes.txt", webfilecontenet);
   
   
}
String search(String username,String content,String databasename,String tablename){
  BdFilewalker walker=new BdFilewalker();
  ArrayList<ArrayList<ArrayList<BdFileContent>>> allfilecontent= walker.main("");
  for(int i=0;i<allfilecontent.size();i++){// loop all files
    ArrayList<ArrayList<BdFileContent>> allfilelist= allfilecontent.get(i);
    for(int j=0;j<allfilelist.size();j++){// loop each files
     ArrayList<BdFileContent> eachfilelist= allfilelist.get(j);
      for(int k=0;k<eachfilelist.size();k++){//loop each row
         BdFileContent eachfilelinelist=   eachfilelist.get(k);
       
        System.out.println( eachfilelinelist.getFilecontent());
       
        
        
        
      }
      
    }
   
  }
 
  return tablename;
}}
