package com.bigdinosaur.core.fs;


public class BdSeekable
{
private int seekposition;
private int noofbytesread;
byte[] bytesread;

public byte[] getBytesread()
{
  return bytesread;
}
public void setBytesread(byte[] bytesread)
{
  this.bytesread = bytesread;
}
public int getSeekposition()
{
  return seekposition;
}
public int getNoofbytesread()
{
  return noofbytesread;
}
public void setSeekposition(int seekposition)
{
  this.seekposition = seekposition;
}
public void setNoofbytesread(int noofbytesread)
{
  this.noofbytesread = noofbytesread;
}

public BdSeekable(int seekposition,int noofbytesread){
  this.seekposition=seekposition;
  this.noofbytesread=noofbytesread;
  bytesread=new byte[noofbytesread];
}


}
