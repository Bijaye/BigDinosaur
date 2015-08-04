package com.bd.core.documentmanagement;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FolderImpl{




  void getListOfFilesLineage( ArrayList<String> listoffilesname) throws IOException{
;    Folder folder=null;
    for(int i=0;i<listoffilesname.size();i++){
      String filepath= listoffilesname.get(i);
      byte[] bytevalue=readByte(filepath);
      folder= CreateFolderTree(filepath, bytevalue,folder);
      
       
     }
    System.out.println(folder);
     
  }
  Folder  CreateFolderTree( String filepath,byte[] bytevalue,Folder folder){
    Folder originaltree = null;
    Folder nextfol;
    if(folder==null){
    Folder Folder=new Folder(filepath,bytevalue);
    originaltree=Folder;
    return Folder;
    }
    else{
       nextfol =new Folder(filepath, bytevalue);
    
     
      while(true){
        if(  nextfol.Foldernext==null){
          
          folder.Foldernext=nextfol;
        }
        return nextfol;
        
      }
     
     
      
    }
   
  }
  
  

  
  static  byte[] readByte(String Folderlinage) throws IOException{
    Path path = Paths.get(Folderlinage);
    byte[] data = Files.readAllBytes(path);
    System.out.println(data.toString());
    String s = new String(data);
    System.out.println("Text Decryted : " + s);
    return data;
    
    
  }

}
