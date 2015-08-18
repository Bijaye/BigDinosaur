package com.bigdinosaur.core.common;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerFirst
    implements Runnable
{
  volatile private Thread t;

  volatile  private String threadName;

  volatile  int port;

  private volatile  ServerSocket serverSocket = null;

  private  volatile DataInputStream dataInputStream = null;

  private volatile  DataOutputStream dataOutputStream = null;
  private  volatile PrintWriter out = null;
  private volatile boolean web =true  ;

  public int getPort()
  {
    return port;
  }

  public void setPort(int port)
  {
    this.port = port;
  }

  public ServerFirst(String name, int port)
  {
    threadName = name;
    this.port = port;
    System.out.println("Creating " + threadName);
  }

  public void run()
  {
    if(!web){

    sendDataToClient(serverSocket, dataInputStream, dataOutputStream);
  }
    else{
      sendDataToClientWeb();
    }
  }
  private void sendDataToClient(ServerSocket serverSocket, DataInputStream dataInputStream,
                                DataOutputStream dataOutputStream)
  {
    // communicate with the client
    try
    {
      ServerStatusChecker checker=new ServerStatusChecker();
      Socket clientSocket=    checker.isClientConnected(serverSocket);
        dataInputStream = new DataInputStream(clientSocket.getInputStream());
        dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
      
     

      Object inputmock = null;
      String inputmock1;
      while (true)
      {
        getDataFromAnotherServer(dataOutputStream);
        
      }
    }
    catch (IOException e)
    {
      System.out.println("Client disconnected from server");
    }

    try
    {
      serverSocket.close();
    }
    catch (Exception e)
    {
    }
  }

  private void getDataFromAnotherServer(DataOutputStream dataOutputStream) throws IOException
  {
    String inputmock1;
    inputmock1=getDataFromAnotherServer();
    dataOutputStream.writeUTF("Welcome to the TCP Echo  Server!");
//        inputmock = getObjectToSendToClient();

    // write data back to client
//        dataOutputStream.writeUTF(input);
//        dataOutputStream.writeBytes(s);
    if(!web){
//          dataOutputStream.write((Byte)inputmock);
      dataOutputStream.writeUTF(inputmock1);
    }
    else{
//          out.println(inputmock);
      dataOutputStream.writeUTF(inputmock1);
    }
  }
  
  private void sendDataToClientWeb()
  {
    // communicate with the client
    try
    {
      ServerStatusChecker checker=new ServerStatusChecker();
      Socket clientSocket=    checker.isClientConnected(serverSocket);
      if(!web){
        dataInputStream = new DataInputStream(clientSocket.getInputStream());
        dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
      
  }
  if(web){
    
    
    out =
        new PrintWriter(clientSocket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(
        new InputStreamReader(clientSocket.getInputStream()));
   
  }
  ClientStart start=new ClientStart();
  start.startClient("127.0.0.1", 810);

      Object inputmock;
        inputmock = getObjectToSendToClient();

        // write data back to client
//        dataOutputStream.writeUTF(input);
//        dataOutputStream.writeBytes(s);
        if(!web){
          dataOutputStream.write((Byte)inputmock);
        }
        else{
          out.println(inputmock);
        }
        
    }
    catch (IOException e)
    {
      System.out.println("Client disconnected from server");
    }

    try
    {
      serverSocket.close();
    }
    catch (Exception e)
    {
    }
  }
  
  

  private Object getObjectToSendToClient() throws IOException
  {
    String input="<!DOCTYPE html><html><head><title>Page Title</title></head><body><h1>This is a Heading</h1><p>This is a paragraph.</p></body></html>";
    return input;
  }

  public void start()
  {
    System.out.println("Starting " + threadName);
    if (t == null)
    {
      t = new Thread(this, threadName);
      t.start();
    }
  }

  void InitializeToCommunicateWithClient()
  {
   
    try
    {
      // open a server socket
      serverSocket = new ServerSocket(port);

      System.out.println("Server created on port " + port);

      System.out.println("Awaiting client connection...");

//      // await for a client connection
//      Socket clientSocket = serverSocket.accept();
//
//      System.out.println("Client connected from  " + clientSocket.getInetAddress());
     

    }
    catch (IOException e)
    {
      System.out.println("Problems initializing server: " + e);
      System.exit(1);
    }
  }
  String getDataFromAnotherServer(){
    ClientStart startclient=new ClientStart();
  return  startclient. startClient("127.0.0.1",822);
   
    
  }

}