package com.bigdinosaur.core.fs;

import java.io.FileWriter;
import java.io.IOException;

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
}
