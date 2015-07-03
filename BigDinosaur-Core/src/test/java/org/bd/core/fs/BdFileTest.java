package org.bd.core.fs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.bigdinosaur.core.database.BdFile;
import org.bigdinosaur.core.database.BdMap;

import com.bigdinosaur.core.fs.BdFileI;
import com.bigdinosaur.core.fs.BdFileRead;
import com.bigdinosaur.core.fs.BdFileWrite;
import com.bigdinosaur.core.io.BdInputI;
import com.bigdinosaur.core.io.BdRead;
import com.bigdinosaur.core.io.BdWriteI;

public class BdFileTest 

{
  public static void main(String[] args) throws IOException
  {
//    copyfiles();
//    readFile();
    readFiles();
  }
  public static void copyfiles(){
  BdFile bdfile=new BdFile(){

    @Override
    public boolean isEndOfFile()
    {
      // TODO Auto-generated method stub
      return false;
    }

    @Override
    public int getFileStart()
    {
      // TODO Auto-generated method stub
      return 0;
    }

    @Override
    public long getRecordCount()
    {
      // TODO Auto-generated method stub
      return 0;
    }

    @Override
    public long getRecordObjectRow()
    {
      // TODO Auto-generated method stub
      return 0;
    }
    
  };
  bdfile.setDirlocation("C://input");
//  bdfile.setDesfoldername("C://output");
  BdFileI.moveBdfObject(bdfile);
  
}
  public static void readFile(){
    BdFileRead readfile=new BdFileRead();
    BdMap map=  readfile.readFile("C://mnt//pd0//logs//2015//06//22/a.txt");
    System.out.println(map.getMaplist());
    BdInputI ii=new BdInputI();
    ii.readString(map);
    for(int i=0;i<map.getMaplist().size();i++){
      System.out.println(map.getMaplist().get(i).getDataMap());
   
      //again rewrite to file and again perform map reduce 
      ;
      
    }
  }
 public void  writeMapReduce() throws IOException{
    BdFileRead readfile=new BdFileRead();
    BdMap map=  readfile.readFile("C://mnt//pd0//logs//2015//06//22/a.txt");
    System.out.println(map.getMaplist());
    BdInputI ii=new BdInputI();
    BdRead data= ii.readString(map);
    FileWriter  out = new FileWriter("output.txt");
    BdWriteI write=new BdWriteI();
    write.writeCharacter(out,data);
    
  }
 public static void readFiles() throws IOException{
   BdFile bdfile=new BdFile();
   bdfile.setDirlocation("C://input");
   BdFileWrite write=new BdFileWrite();
   List<File> list =write.getFileList(bdfile);
   
   for(File x:list){
     BdFileRead readfile=new BdFileRead();
     BdMap map=  readfile.readFile(x.getAbsolutePath());
     System.out.println(map.getMaplist());
     BdInputI ii=new BdInputI();
     BdRead data= ii.readString(map);
     FileWriter  out = new FileWriter("output.txt");
     BdWriteI writei1=new BdWriteI();
     writei1.writeCharacter(out,data);
     
   }
 }
}
