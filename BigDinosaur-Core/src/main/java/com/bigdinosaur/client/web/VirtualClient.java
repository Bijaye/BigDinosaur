package com.bigdinosaur.client.web;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.bigdinosaur.common.server.ServerThird;
 
public class VirtualClient
{
    
    

    private static void startClient(String string, int i)
    {
      ClientStart startclient=new ClientStart();
      startclient. startClient("127.0.0.2",821);
//      ServerThird f=new ServerThird("Thread-1");
//      f.start();
      
    }


   
}    
