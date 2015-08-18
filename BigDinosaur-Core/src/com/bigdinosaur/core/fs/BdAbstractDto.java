package com.bigdinosaur.core.fs;

public class BdAbstractDto
{
  // it is related to single file path 

  int bufferSize = -1;
  short replication = -1;
  long blockSize = -1;
  int bytesPerChecksum = -1;
  int noofreplication;
  int ownerfilepath;
  int filechecksum;
  int filestatuspath;
  int[] blocklocation;
  
}
