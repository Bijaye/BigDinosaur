package org.bigdinosaur.core.database;

public interface BdStreamOut
{
  void writeEnd();

  void writeSize(int size);

  void writeType(int type);

  void writeString(String value);

  void writeByte(int i);

  void writeChar(int i);

  void writeShort(int i);

  void writeInt(int i);

  void writeIntData(int i, int position);

  void writeLong(long i);

  void writeData(Object row, BdGraphType[] types);

  void writeData(int l, BdGraphType[] types, Object[] data, Object cols,
                 int[] primarykeys);

  int getSize(Object row);

  int getStorageSize(int size);

  // returns the underlying BdByteArrayStream
  BdByteArrayStream getOutputStream();

  byte[] getBuffer();

  // resets the byte[] buffer, ready for processing new row
  void reset();

  // performs reset() and ensures byte[] buffer is at least newSize
  void reset(int newSize);

  // sets the byte[] buffer
  void reset(byte[] mainBuffer);

  // returns the current size
  int size();

}
