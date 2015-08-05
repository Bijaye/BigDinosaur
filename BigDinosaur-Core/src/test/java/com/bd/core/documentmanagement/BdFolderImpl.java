package com.bd.core.documentmanagement;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BdFolderImpl{




  void getListOfFilesLineage( ArrayList<String> listoffilesname) throws IOException{
;    BdFolder folder=null;
    for(int i=0;i<listoffilesname.size();i++){
      String filepath= listoffilesname.get(i);
      byte[] bytevalue=readByte(filepath);
      folder= CreateFolderTree(filepath, bytevalue,folder);
      
       
     }
    System.out.println(folder);
     
  }
  BdFolder  CreateFolderTree( String filepath,byte[] bytevalue,BdFolder folder){
    BdFolder originaltree = null;
    BdFolder nextfol;
    if(folder==null){
    BdFolder Folder=new BdFolder(filepath,bytevalue);
    originaltree=Folder;
    return Folder;
    }
    else{
       nextfol =new BdFolder(filepath, bytevalue);
    
     
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
