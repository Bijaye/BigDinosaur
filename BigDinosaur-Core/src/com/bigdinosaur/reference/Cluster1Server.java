package com.bigdinosaur.reference;

import java.net.*;
import java.io.*;
   //Wordware.Java.1.4.Game.Programming.eBook-LiB
public class Cluster1Server
{
    public static void main(String args[])
    {
      Cluster1Client client=new Cluster1Client();
      client.main(args);
        int port = 8001;
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
    
            System.out.println("Client connected from   "+clientSocket.getInetAddress());
              
    
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
          // this value has to be read from another server 
       
        
          
            dataOutputStream.writeUTF(client.getMessage());
             
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
}
 
