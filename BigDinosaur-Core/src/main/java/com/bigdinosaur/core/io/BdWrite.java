package com.bigdinosaur.core.io;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;

public interface BdWrite
{
  BdRead writeByte(OutputStream stream,BdRead data);
  BdRead writeCharacter(FileWriter stream,BdRead data);
  byte[] getByteArray(ByteArrayOutputStream baos ); 
}

