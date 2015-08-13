package com.bigdinosaur.bigdata.node;

import java.io.IOException;
/**
 * Public interface for reading the data for a cluster .
 *

 */
public interface RowInputInterface
{
  long getPos();

  int getSize();

  int readType() throws IOException;

  String readString() throws IOException;

  byte readByte() throws IOException;

  char readChar() throws IOException;

  short readShort() throws IOException;

  int readInt() throws IOException;

  long readLong() throws IOException;

  Object[] readData(Type[] colTypes) throws IOException;

  void resetRow(long filePos, int size);

  void resetBlock(long filePos, int size);

  byte[] getBuffer();
}
