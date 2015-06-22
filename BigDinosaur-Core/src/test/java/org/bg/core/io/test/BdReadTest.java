package org.bg.core.io.test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import junit.framework.TestCase;

import com.bigdinosaur.core.io.BdInputI;
import com.bigdinosaur.core.io.BdRead;
import com.bigdinosaur.core.io.BdWriteI;
// It is applicable after output is written in files .For example map reduce is run and final result is there in 
// file and which need to be read and send to another server or client 
public class BdReadTest extends TestCase
{
  static BdRead data;
  public static void main(String[] args) throws IOException
  {
//    testBdReadByte();
//    testBdWriteByte();
//    testBdReadCharacter();
//    testBdWriteCharacter();
//    testBdByteBufferWrite();
  }
  
  public static void  testBdReadByte() throws FileNotFoundException{
   FileInputStream   in = new FileInputStream("input.txt");
  BdInputI test=new BdInputI();
  data= test.readByte(in);
 }
 public  static void  testBdWriteByte() throws FileNotFoundException{
   FileOutputStream  out = new FileOutputStream("output.txt");
   BdWriteI write=new BdWriteI();
   write.writeByte(out,data);
 }
 public static void  testBdReadCharacter() throws FileNotFoundException{
   FileReader   in = new FileReader("input.txt");
  BdInputI test=new BdInputI();
  data= test.readCharacter(in);
 }
 public static void  testBdWriteCharacter() throws IOException{
   FileWriter  out = new FileWriter("output.txt");
   BdWriteI write=new BdWriteI();
   write.writeCharacter(out,data);
 }
 public static void  testBdByteBufferWrite() throws IOException{
   ArrayList<BdRead> dataarray=new ArrayList<BdRead>();
   BdRead data =new BdRead();
   data.setI(11);
   dataarray.add(data);
   data.setReaddata(dataarray);
   ByteArrayOutputStream baos = new ByteArrayOutputStream();
   BdWriteI write=new BdWriteI();
   write.writeByte(baos,data);
   byte[] value= write.getByteArray(baos);
  
   
  
 }

}
