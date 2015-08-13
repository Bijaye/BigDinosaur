package org.bigdinosaur.core.database;

public class BdFileRow
{
  byte[] filedata;
  int fileindex;
   BdFileRow eachrow;
  public byte[] getFiledata()
  {
    return filedata;
  }
  public int getFileindex()
  {
    return fileindex;
  }
  public BdFileRow getEachrow()
  {
    return eachrow;
  }
  public void setFiledata(byte[] filedata)
  {
    this.filedata = filedata;
  }
  public void setFileindex(int fileindex)
  {
    this.fileindex = fileindex;
  }
  public void setEachrow(BdFileRow eachrow)
  {
    this.eachrow = eachrow;
  }

}
