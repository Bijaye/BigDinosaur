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
  boolean[] ispathbelongstofilesystem;
  //start offset into the given file
  String offstartset;
  String endoffset;
  //the current offset from the start of the file
  int fileposition;
  int sizeofportionoffile;
  int nooffileswriteoperation;
  int nooffilereadoperation;
  int totalnoofbytewritten;
  int totalnoofbyteread;
  int fileacesstime;
  // it need to be set on file 
  int fileowner;
  int filegroup;
  //This is only applicable if the  corresponding FileSystem supports checksum
  boolean verifychecksumflag;
  String defaultreplicationpath;
  String link;
 // file in sense of single file ,every single file has working dir,it has length 
  // file has length ,isDir, 1, blockSize, modTime, accessTime,
  //perms, owner, group, symlink, qualified
  // FileStatus for single files 
  
  int filetotalspace;
  int filefreespace;
  boolean ispathpermissionallowed;
  boolean ispathexists;
  boolean isdirectoryempty;
  boolean ispathdirectory;
  String[] pathnamelist;
  boolean ispathalreadyexists;
  boolean ispathaccessallowed;
  boolean isparentdirectory;
 String baseUri;
 String parturi;
 boolean ispathvalid;
 String homedirectory;
 boolean iscreateparent;
 //default server configuration 
// private long blockSize;
  int writePacketSize;
// private short replication;
  int fileBufferSize;
  boolean encryptDataTransfer;
  
  
}
