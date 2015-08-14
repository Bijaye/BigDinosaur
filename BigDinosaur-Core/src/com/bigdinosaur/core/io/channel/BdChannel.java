package com.bigdinosaur.core.io.channel;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

public interface BdChannel
{
  public abstract Object decode(DataInput paramDataInput)
      throws IOException;

  public abstract void encode(DataOutput paramDataOutput)
      throws IOException;
  
  void sendDataToClient(ServerSocket serverSocket, DataInputStream dataInputStream,
                        DataOutputStream dataOutputStream);
Object getObjectToSendToClient( DataInputStream dataInputStream);
Object createServer(String port);
}
