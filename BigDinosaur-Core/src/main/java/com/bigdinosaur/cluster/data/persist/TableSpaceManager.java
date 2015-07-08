package com.bigdinosaur.cluster.data.persist;
// space is allocated for every table on serve.It manages that space .
//Manages allocation of space for rows
public interface TableSpaceManager
{
  public long getFilePosition(long rowSize, boolean asBlocks);
  public boolean hasFileRoom(long blockSize) ;
  public void addFileBlock(long blockFreePos, long blockLimit);
  public void reset();
  

}
