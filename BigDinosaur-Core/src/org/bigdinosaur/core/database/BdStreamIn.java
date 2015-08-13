package org.bigdinosaur.core.database;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;


public interface BdStreamIn
{
  public abstract Object decode(DataInput paramDataInput)
      throws IOException;

  public abstract void encode(DataOutput paramDataOutput)
      throws IOException;
  long getPos();

  int getSize();

  int readType() throws IOException;

  String readString() throws IOException;

  byte readByte() throws IOException;

  char readChar() throws IOException;

  short readShort() throws IOException;

  int readInt() throws IOException;

  long readLong() throws IOException;

  Object[] readData(BdGraphType[] colTypes) throws IOException;

  void resetRow(long filePos, int size);

  void resetBlock(long filePos, int size);

  byte[] getBuffer();
  void sendDataToClient(ServerSocket serverSocket, DataInputStream dataInputStream,
                        DataOutputStream dataOutputStream);
Object getObjectToSendToClient( DataInputStream dataInputStream);
}
