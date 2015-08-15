package com.bigdinosaur.core.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import org.bigdinosaur.core.database.BdFile;


public class BdChanneCl
{

  void connectServer(String url){
    try
    {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(url,
            9000));
        
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
        String string = incomingData.asCharBuffer().toString();
        
        
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
Object   passObject(BdFile obj){
  return obj;
    
  }
}
