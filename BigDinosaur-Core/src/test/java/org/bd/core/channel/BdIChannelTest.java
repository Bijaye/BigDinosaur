package org.bd.core.channel;

import java.io.IOException;

import com.bigdinosaur.core.channel.BdIChannel;

public class BdIChannelTest
{
  public static void main(String[] args) throws IOException
  {
    runServer();
  }
  public static void  runServer() throws IOException{
    BdIChannel channel=new  BdIChannel();
    channel.createServer(8090);
    
  }
 

}
