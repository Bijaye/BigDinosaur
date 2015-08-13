package com.bigdinosaur.common.server;


  public   class MultiServer implements Runnable {
    private int i;
   
    public int getI()
    {
      return i;
    }
    public void setI(int i)
    {
      this.i = i;
    }
    public MultiServer( int i){
      this.i=i;
    }
    public void run() {
      
      
      ServerFirst d=new ServerFirst("Thread"+i,808+i);
      
//    ServerSecond e=new ServerSecond("Thread-1");
 
    d.InitializeToCommunicateWithClient();
    d.start();
    }    
    
    
    public void start ()
    {
     
      Thread    t = new Thread (this, "Thread");
          t.start ();
       }
    }
