package org.bd.core.fs;

import org.bigdinosaur.core.database.BdFile;

import com.bigdinosaur.core.fs.BdFileI;

import junit.framework.TestCase;

public class BdFileTest extends TestCase
{
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
}
