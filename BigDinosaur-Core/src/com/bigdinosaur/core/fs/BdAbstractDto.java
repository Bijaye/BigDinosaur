package com.bigdinosaur.core.fs;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.security.AccessControlException;
import java.util.List;

import com.bigdinosaur.cluster.acl.FsPermission;

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
  int sizeofportionoffile;
  int nooffileswriteoperation;
  int nooffilereadoperation;
  int totalnoofbytewritten;
  int totalnoofbyteread;
  int fileacesstime;
  int fileowner;
  //This is only applicable if the  corresponding FileSystem supports checksum
  boolean verifychecksumflag;
  String defaultreplicationpath;
  String link;
  // file has length ,isDir, 1, blockSize, modTime, accessTime,
  //perms, owner, group, symlink, qualified
  
  
}
