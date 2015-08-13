package com.bigdinosaur.core.fs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bigdinosaur.core.database.BdFile;
import org.bigdinosaur.core.database.BdMap;

import com.bigdinosaur.core.io.BdRead;
import com.bigdinosaur.core.io.BdWriteI;

public class BdFileWrite
{
  void writeData(   BdRead data,BdMap map) throws IOException{
  FileWriter  out = new FileWriter("output.txt");
  BdWriteI write=new BdWriteI();
  write.writeCharacter(out,data);
}
  public List<File>getFileList(BdFile bdfile){
    List<File> list=new ArrayList<File>();
    File source = new File(bdfile.getDirlocation());
    String files[] = source.list();

    for (String temp : files)
    {
      File filei =null;
      File file = new File(source, temp);
      if(file.isDirectory()){
        String filesd[] = file.list();

        for (String filed: filesd)
        {
           filei = new File(file, filed);
        }
          list.add(filei);
      }
      else{
        list.add(file);
      }
   
      

    }
    return list;
  }
}
