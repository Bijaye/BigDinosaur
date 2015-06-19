package org.bg.core.io.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.bigdinosaur.core.io.BdInputI;
import com.bigdinosaur.core.io.BdRead;
import com.bigdinosaur.core.io.BdWriteI;

public class BdReadTest
{
  static BdRead data;
  public static void main(String[] args) throws IOException
  {
//    testBdReadByte();
//    testBdWriteByte();
    testBdReadCharacter();
    testBdWriteCharacter();
  }
  
 static void  testBdReadByte() throws FileNotFoundException{
   FileInputStream   in = new FileInputStream("input.txt");
  BdInputI test=new BdInputI();
  data= test.readByte(in);
 }
 static void  testBdWriteByte() throws FileNotFoundException{
   FileOutputStream  out = new FileOutputStream("output.txt");
   BdWriteI write=new BdWriteI();
   write.writeByte(out,data);
 }
 static void  testBdReadCharacter() throws FileNotFoundException{
   FileReader   in = new FileReader("input.txt");
  BdInputI test=new BdInputI();
  data= test.readCharacter(in);
 }
 static void  testBdWriteCharacter() throws IOException{
   FileWriter  out = new FileWriter("output.txt");
   BdWriteI write=new BdWriteI();
   write.writeCharacter(out,data);
 }

}
