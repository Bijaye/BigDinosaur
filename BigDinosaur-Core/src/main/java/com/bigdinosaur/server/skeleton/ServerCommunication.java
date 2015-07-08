package com.bigdinosaur.server.skeleton;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;

public interface ServerCommunication
{
   void sendDataToClient(ServerSocket serverSocket, DataInputStream dataInputStream,
                                DataOutputStream dataOutputStream);
   Object getObjectToSendToClient( DataInputStream dataInputStream);
}
