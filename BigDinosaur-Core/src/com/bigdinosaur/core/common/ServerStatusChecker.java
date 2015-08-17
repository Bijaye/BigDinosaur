package com.bigdinosaur.core.common;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerStatusChecker
{

  public Socket isClientConnected( ServerSocket serverSocket) throws IOException  {
  Socket clientSocket = serverSocket.accept();

  System.out.println("Client connected from  " + clientSocket.getInetAddress());
  return clientSocket;
  
  
}
}