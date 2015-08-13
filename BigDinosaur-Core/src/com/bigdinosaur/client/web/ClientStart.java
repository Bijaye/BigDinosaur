package com.bigdinosaur.client.web;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientStart
{
  private volatile Socket socket = null;
  private volatile DataInputStream dataInputStream = null;
  private volatile DataOutputStream dataOutputStream = null;
  private volatile String serverdata = null;

  public  String startClient(String address, int port)
  {

    
    try
    {
      initializeClientObject(address, port);
      StartRead reader = new StartRead(dataInputStream);
      serverdata= reader.getServerdata();

      reader.setDaemon(true);
      reader.start();

      String input;
         input="send me html";
   
        // send data to server
        dataOutputStream.writeUTF(input);
        SendClientDataToServer read=new SendClientDataToServer();
        read.writeClientDataToServer(dataOutputStream, input);

    }
    catch (IOException e)
    {
    }

    try
    {
      socket.close();
    }
    catch (IOException e)
    {
    }
    return serverdata;
  }
  void initializeClientObject(String address, int port){
   

    try
    {
      socket = new Socket(address, port);
      dataInputStream = new DataInputStream(socket.getInputStream());
      dataOutputStream = new DataOutputStream(socket.getOutputStream());
    }
    catch (IOException e)
    {
      System.out.println("Problems initialising: " + e);
      System.exit(1);
    }

  }
}
