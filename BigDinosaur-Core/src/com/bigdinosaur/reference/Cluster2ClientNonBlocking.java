package com.bigdinosaur.reference;


import java.nio.*;
import java.nio.channels.*;
import java.io.*;
import java.net.*;
   
public class Cluster2ClientNonBlocking
{
  private static  String string;
  public  String getMessage()
{
  return string;
}

    public static void main(String[] args)
    {
        try
        {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1",
               8001));
            
            // wait for the message from the server...
            ByteBuffer incomingLengthInBytes =
                ByteBuffer.allocate(4); // size of an 'int'
            socketChannel.read(incomingLengthInBytes);
            incomingLengthInBytes.rewind();
            int incomingLength = incomingLengthInBytes.getInt();
            System.out.println("Got Incoming Length as:      "+incomingLength+" bytes");
          
            
            // now allocate the correct size for the message...
            ByteBuffer incomingData =
                ByteBuffer.allocate(incomingLength);
            socketChannel.read(incomingData);
            incomingData.rewind();
             string = incomingData.asCharBuffer().toString();
            
            
            // Finally print the received message...
            System.out.println("Received: "+string);
            
            
            // Send a message back to the server...
            String replyMessage = "Message Received - Thank you!";
            int length = replyMessage.length() * 2;
            
            ByteBuffer replyLength = ByteBuffer.allocate(4);
            replyLength.putInt(length);
            replyLength.rewind();
            
            ByteBuffer replyText = ByteBuffer.allocate(length);
            replyText.asCharBuffer().put(replyMessage);
            
            ByteBuffer toSend[] = {replyLength, replyText};
            socketChannel.write(toSend);
            
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        
    }    
}
