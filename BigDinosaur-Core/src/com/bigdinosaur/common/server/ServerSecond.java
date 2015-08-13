package com.bigdinosaur.common.server;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSecond implements Runnable {
   private Thread t;
   private String threadName;
   
   public ServerSecond( String name){
       threadName = name;
       System.out.println("Creating " +  threadName );
   }
   public void run() {
     int port = 8001;
     ServerSocket serverSocket = null;
     DataInputStream dataInputStream = null;
     DataOutputStream dataOutputStream = null;
     PrintWriter out = null;
     
     try
     {
         // open a server socket
         serverSocket = new ServerSocket(port);
         
         System.out.println("Server created on port "+port);
 
         System.out.println("Awaiting client connection...");
 
         // await for a client connection
         Socket clientSocket = serverSocket.accept();
 
         System.out.println("Client connected from  "+clientSocket.getInetAddress());
           
 
//         dataInputStream = new DataInputStream
//             (clientSocket.getInputStream());
//         dataOutputStream = new DataOutputStream
//             (clientSocket.getOutputStream());
         
          out =
             new PrintWriter(clientSocket.getOutputStream(), true);
         BufferedReader in = new BufferedReader(
             new InputStreamReader(clientSocket.getInputStream()));
     }
     catch(IOException e)
     {
         System.out.println("Problems initializing server: "+e);
         System.exit(1);
     }
 
 
 
     // communicate with the client
     
//         dataOutputStream.writeUTF("Welcome to the TCP Echo  Server!");
//            
//         String input;
//         while(true)
         {
             // read data in from client
//             input = dataInputStream.readUTF();
             String inputmock="<!DOCTYPE html><html><head><title>Page Title</title></head><body><h1>This is a Heading</h1><p>This is a paragraph.</p></body></html>";
             
             System.out.println("You typed: "+inputmock);
 
             // write data back to client
//             dataOutputStream.writeUTF(inputmock);
//             PrintWriter        d= new PrintWriter(dataOutputStream ) ;
             out.println(inputmock);
         
         }
     
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