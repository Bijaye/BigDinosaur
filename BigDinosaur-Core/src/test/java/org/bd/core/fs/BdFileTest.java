package org.bd.core.fs;

import org.bigdinosaur.core.database.BdFile;
import org.bigdinosaur.core.database.BdMap;

import com.bigdinosaur.core.fs.BdFileI;
import com.bigdinosaur.core.fs.BdFileRead;

public class BdFileTest 

{
  public static void main(String[] args)
  {
    readFile();
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
  bdfile.setDesfoldername("C://output");
  BdFileI.moveBdfObject(bdfile);
  
}
  public static void readFile(){
    BdFileRead readfile=new BdFileRead();
    BdMap map=  readfile.readFile("C://mnt//pd0//logs//2015//06//22/a.txt");
    System.out.println(map.getMaplist());
  }
}
