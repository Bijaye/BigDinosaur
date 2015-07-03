package com.bigdinosaur.core.io.channel;

import org.bigdinosaur.core.database.BdFile;

public class BdChannel
{
  public static void main(String[] args)
  {
    BdChanneCl channel=new BdChanneCl();
   
    channel.connectServer("127.0.0.1");
    //pass files ,it cane be block of files all processing will be performed on another server
   //Bdfile object represent block of file 
    BdFile obj = null;
    channel.passObject(obj);
//    channel.passObject(obj)
  }

}
