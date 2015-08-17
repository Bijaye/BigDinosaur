package com.bigdinosaur.core.common;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThird implements Runnable {
   private Thread t;
   private String threadName;
   
   public ServerThird( String name){
       threadName = name;
       System.out.println("Creating " +  threadName );
   }
   public void run() {
     
     int port = 8003;
     ServerSocket serverSocket = null;
     DataInputStream dataInputStream = null;
     DataOutputStream dataOutputStream = null;
     
     try
     {
         // open a server socket
         serverSocket = new ServerSocket(port);
         
         System.out.println("Server created on port "+port);
 
         System.out.println("Awaiting client connection...");
 
         // await for a client connection
         Socket clientSocket = serverSocket.accept();
 
         System.out.println("Client connected from  "+clientSocket.getInetAddress());
           
 
         dataInputStream = new DataInputStream
             (clientSocket.getInputStream());
         dataOutputStream = new DataOutputStream
             (clientSocket.getOutputStream());
     }
     catch(IOException e)
     {
         System.out.println("Problems initializing server: "+e);
         System.exit(1);
     }
 
 
 
     // communicate with the client
     try
     {
         dataOutputStream.writeUTF("Welcome to the TCP Echo  Server!");
            
         String input;
         while(true)
         {
             // read data in from client
             input = dataInputStream.readUTF();
             System.out.println("You typed: "+input);
 
             // write data back to client
             dataOutputStream.writeUTF(input);
         }
     }
     catch(IOException e)
     {
         System.out.println("Client disconnected from server");
     }
     
     try
     {
         serverSocket.close();
     }
     catch(Exception e) { }
   }    
   
   
   public void start ()
   {
      System.out.println("Starting " +  threadName );
      if (t == null)
      {
         t = new Thread (this, threadName);
         t.start ();
      }
   }

}