package org.bd.core.mp;

import java.io.FileWriter;
import java.io.IOException;

import org.bigdinosaur.core.database.BdMap;

import com.bigdinosaur.core.fs.BdFileRead;
import com.bigdinosaur.core.io.BdInputI;
import com.bigdinosaur.core.io.BdRead;
import com.bigdinosaur.core.io.BdWriteI;

public class MrTest
{
  public static void main(String[] args) throws IOException
  {
    writeMapReduce();
  }
  public static void  writeMapReduce() throws IOException{
    BdFileRead readfile=new BdFileRead();
    BdMap map=  readfile.readFile("C://mnt//pd0//logs//2015//06//22/a.txt");
    System.out.println(map.getMaplist());
    BdInputI ii=new BdInputI();
    BdRead data= ii.readString(map);
    FileWriter  out = new FileWriter("output.txt");
    BdWriteI write=new BdWriteI();
    write.writeString(out,data);
    
  }
}
