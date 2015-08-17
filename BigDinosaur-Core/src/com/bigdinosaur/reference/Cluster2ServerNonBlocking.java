package com.bigdinosaur.reference;


import java.nio.*;
import java.nio.channels.*;
import java.io.*;
import java.net.*;
import java.util.*;
   
public class Cluster2ServerNonBlocking
{
    public static void main(String[] args)
    {
        try
        {
            Selector selector = Selector.open();
            
            ServerSocketChannel serverSocketChannel =
                ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            
            ServerSocket serverSocket = serverSocketChannel.socket();
            
            serverSocket.bind(new InetSocketAddress(8002));
            
            System.out.println("Non-blocking Server created on port  8002");
              
            
            serverSocketChannel.register(selector,
                SelectionKey.OP_ACCEPT);
            
            System.out.println("Waiting for client connections...");
            
            int amountToProcess = 0;
            while(true)
            {
                amountToProcess = selector.selectNow();
        
                if(amountToProcess > 0)
                {
                    try
                    {
                        Set keys = selector.selectedKeys();
        
                        Iterator iterator = keys.iterator();
                        
                        while(iterator.hasNext())
                        {
                            SelectionKey selectionKey =
                                (SelectionKey) iterator.next();
                            iterator.remove(); // remove the key
        
            
                            int operation = selectionKey
                                .interestOps();
            
                            if((SelectionKey.OP_ACCEPT & operation)
                                != 0)
                            {
                                // Accept the connection...
                                ServerSocketChannel channel =
                                    (ServerSocketChannel) 
                                    selectionKey.channel();
                                SocketChannel socket =
                                    channel.accept();
                                socket.configureBlocking(false);
            
                                // register for a writing operation
                                socket.register(selector,
                                    SelectionKey.OP_WRITE);
            
                                System.out.println("Client Connected...");
                                   
                            }
                            else if((SelectionKey.OP_READ &
                                operation) != 0)
                            {
                                // Attempt to read...
                                System.out.println("About to read  from client...");
                                  
                
                                SocketChannel socket =
                                   (SocketChannel) selectionKey
                                   .channel();
                
                                // get the message from the client...
                                ByteBuffer incomingLengthInBytes =
                                    ByteBuffer.allocate(4); 
                                // size of an 'int'
                                socket.read(incomingLengthInBytes);
                                incomingLengthInBytes.rewind();
                                int incomingLength =
                                    incomingLengthInBytes.getInt();
                                System.out.println("Got Incoming Length as: "+incomingLength+"    bytes");
                                
                                   
                
                                // now allocate the correct size for
                                // the message...
                                ByteBuffer incomingData = ByteBuffer
                                    .allocate(incomingLength);
                                socket.read(incomingData);
                                incomingData.rewind();
                                String string = incomingData
                                    .asCharBuffer().toString();
                
                
                                // Finally print received message...
                                System.out.println("Received:  "+string);
                                  
                
                                // terminate the connection...
                                socket.close();
                            }
                            else if((SelectionKey.OP_WRITE &
                                operation) != 0)
                            {
                                // Attempt to write...
                
                
                                System.out.println("Now going to  write to client...");
                                  
                
                                SocketChannel socket =
                                    (SocketChannel) selectionKey
                                    .channel();
                
                                socket.register(selector,
                                    SelectionKey.OP_READ);
                
                                String stringToSend = "This is a  message to send to client ";
                                  
                
                                int length = stringToSend.length() 
                                    * 2;
                
                                ByteBuffer lengthInBytes =
                                    ByteBuffer.allocate(4);    
                                    // 4 = size of a 'int'
                                ByteBuffer dataToSend =
                                    ByteBuffer.allocate(length);
                
                                lengthInBytes.putInt(length);
                                lengthInBytes.rewind();
                                dataToSend.asCharBuffer()
                                    .put(stringToSend);
                
                                ByteBuffer sendArray[] =
                                    {lengthInBytes, dataToSend};
                
                                socket.write(sendArray);
                                //socket.close();
                                System.out.println("Sent Message to Client...");
                                   
                            }
                        }
                    }
                    catch(IOException e)
                    {
                        System.out.println(e);
                    }
                }
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        
    }
}

