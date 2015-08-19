package com.bigdinosaur.core.fs;

import java.net.URI;

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
  String permission;
  boolean issourcefilevalid;
  String baseuri;
  String urischeme;
  String checkpathbelongtofilesystem;
  String uripath;
  String initialworkingdirectory;
  String workingdirectory;
  String[] serverdefaultconfigurationvalues;
  String[] cacheoffiles;
  String defaulturi;
  String canonialuri;
  //If the file system has child file systems 
  BdAbstractDto[] childfilenames;
  
  BdAbstractDto localfilesystem;
  String tokenforeachfilesystem;
  String[] tokenallfilesystem;
  String[] permissionforfilesystem;
  String[] directoriespermission;
  
  
  /**
   * Get a filesystem instance based on the uri
   * names the host, port, etc.
   *   for this FileSystem
   */
  
  BdAbstractDto getFileSystemInstance(URI uri ){
    return null;
    
  }
}
