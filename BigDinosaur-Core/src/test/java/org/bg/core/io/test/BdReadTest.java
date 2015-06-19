package org.bg.core.io.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.bigdinosaur.core.io.BdInputI;

public class BdReadTest
{
  public static void main(String[] args) throws FileNotFoundException
  {
    testBdRead();
  }
  
 static void  testBdRead() throws FileNotFoundException{
   FileInputStream   in = new FileInputStream("input.txt");
  BdInputI test=new BdInputI();
  test.read(in);
  System.out.println( test.read(in));
 }

}
