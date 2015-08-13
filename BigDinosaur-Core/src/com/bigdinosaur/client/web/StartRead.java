package com.bigdinosaur.client.web;

import java.io.DataInputStream;
import java.io.IOException;

public  class StartRead extends Thread
    {
  private volatile int value;
  private volatile String serverdata;
        public String getServerdata()
  {
    return serverdata;
  }

  public void setServerdata(String serverdata)
  {
    this.serverdata = serverdata;
  }

        public StartRead(DataInputStream input)
        {
            dataInputStream = input;
            active = true;
        }
    
        public void run()
        {
            while(active)
            {
                try
                {
                  serverdata = dataInputStream.readUTF();
                    System.out.println("Received from server:       "+serverdata);
                    
                 
                }
                catch(IOException e)
                {
                    System.out.println(e);
                    active = false;
                }
            }
        }
        public int getValue() {
          return value;
      }
        
        public boolean active;
        public DataInputStream dataInputStream;
    }
    