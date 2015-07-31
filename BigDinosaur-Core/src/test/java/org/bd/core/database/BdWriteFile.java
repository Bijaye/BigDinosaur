package org.bd.core.database;

import java.io.FileOutputStream;
import java.io.IOException;
// there can be flexibility on how the user want to save data 
// User can save data in two ways 
// D//movies/movie1.mp3,movie2.mp3,movie3.mp3
//D//movies/Hindi/Oldmovie/movie1.mp3
//D//movies/Hindi/newmovie/movie2.mp3
import java.util.ArrayList;
import java.util.Map;

//First create database folder-it is database name 
//create table folder-e.g company table ,user table ,Likes table,Follow table 
// Create file index table 
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
   //first search in indexed location.
   //if not found then only search in real location
   String index=searchIndexing("D://database//fileindex//fileindex.txt","123");
   if(index==null){
   System.out.println(write.search("", "123", "", ""));
   }
   else{
     System.out.println("file content path  from indexing" + index);
   }
   
   
   
   
   // look up session
   // if session is not expired retrive from cache 
   // if session is expired then search from database with username 
   
   
  
 String webfilecontenet="abishkar billgates ,larypage ";
 String filename="follow";
 
// write.write("D://database//user//follow//likes.txt", webfilecontenet);
   
   
}
public static  String searchIndexing(String indexlocation,String id){
   BdFilewalker walker=new BdFilewalker();
   Map<String,String> map=  walker.readasMap(indexlocation);
   String reallocation=map.get(id);
   if(reallocation!=null){
     System.out.println(reallocation);
     
  
   }
  return reallocation;
   
 }
 // before executing this method indexing value is need to be searched ,if it is not found in indexing then only this method is executed and it is indexed 
String search(String username,String content,String databasename,String tablename) throws IOException{
  BdFilewalker walker=new BdFilewalker();
  ArrayList<ArrayList<ArrayList<BdFileContent>>> allfilecontent= walker.main("");
  for(int i=0;i<allfilecontent.size();i++){// loop all files
    ArrayList<ArrayList<BdFileContent>> allfilelist= allfilecontent.get(i);
    for(int j=0;j<allfilelist.size();j++){// loop each files
     ArrayList<BdFileContent> eachfilelist= allfilelist.get(j);
      for(int k=0;k<eachfilelist.size();k++){//loop each row
         BdFileContent eachfilelinelist=   eachfilelist.get(k);
        
       
        System.out.println( eachfilelinelist.getFilecontent());
        if(eachfilelinelist.getFilecontent().equals(content)){
          FileIndexing indexfile=new FileIndexing();
          String folderpath=eachfilelinelist.getFolderpath();
          indexfile.setIndexlocation(folderpath);
          indexfile.setKey(content);
          System.out.println( eachfilelinelist.getFolderpath());
          write("D://database//fileindex//fileindex.txt", indexfile.toString());
          
          return eachfilelinelist.getFolderpath();
          
          
        }
       
       
        
        
        
      }
      
    }
   
  }
 
  return tablename;
}}
