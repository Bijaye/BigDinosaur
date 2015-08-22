package com.bigdinosaur.core.fs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.security.AccessControlException;
import java.util.List;

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
  
  
  /** Return the total size of all files in the filesystem.*/
  public long getUsed() throws IOException{
    long used = 0;
    FileStatus[] files = new FileStatus[11];
    for(FileStatus file:files){
      used += file.getLen();
    }
    return used;
  }
  
  /**
   * Get the block size for a particular file.
   * @param f the filename
   * @return the number of bytes in a block
   */
  public long getBlockSize(Path f) throws IOException {
    return 222;
  }
  
  
  /**
   * Return the number of bytes that large input files should be optimally
   * be split into to minimize i/o time.
   * 
   */
  public long getDefaultBlockSize() {
    // default to 32MB: large enough to minimize the impact of seeks
    return 4000;
  }
  
  /**
   * Get the default replication for a path.   The given path will be used to
   * locate the actual filesystem.  The full path does not have to exist.
   * @param path of the file
   * @return default replication for the path's filesystem 
   */
  public short getDefaultReplication(Path path) {
    return 20;
  }
  /** Return the number of bytes that large input files should be optimally
   * be split into to minimize i/o time.  The given path will be used to
   * locate the actual filesystem.  The full path does not have to exist.
   * @param f path of file
   * @return the default block size for the path's filesystem
   */
  public long getDefaultBlockSize(Path f) {
    return 20;
  }
  
  
  
  
  /**
   * Checks if the user can access a path.  The mode specifies which access
   * checks to perform.  If the requested permissions are granted, then the
   * method returns normally.  If access is denied, then the method throws an
   * AccessControlException
   * 
   * The default implementation of this method calls getFileStatus(Path)
   * and checks the returned permissions against the requested permissions.
   * Note that the getFileStatus call will be subject to authorization checks.
   * Typically, this requires search (execute) permissions on each directory in
   * the path's prefix, but this is implementation-defined.  Any file system
   * that provides a richer authorization model (such as ACLs) may override the
   * default implementation so that it checks against that model instead.
   * 
   * In general, applications should avoid using this method, due to the risk of
   * time-of-check/time-of-use race conditions.  The permissions on a file may
   * change immediately after the access call returns.  Most applications should
   * prefer running specific file system actions as the desired user represented
   * by a  UserGroupInformation
   *
   * @param path Path to check
   * @param mode type of access to check
   * @throws AccessControlException if access is denied
   * @throws FileNotFoundException if the path does not exist
   * @throws IOException see specific implementation
   */
  
  public void hasaccess(Path path, Object mode) throws AccessControlException,
  FileNotFoundException, IOException {

}
  /**
   * Get the checksum of a file, from the beginning of the file till the
   * specific length.
   * @param f The file path
   * @param length The length of the file range for checksum calculation
   * @return The file checksum.
   */
  public Object getFileChecksum(Path f, final long length)
      throws IOException {
    return null;
  }
  
  /**
   * Get a filesystem instance based on the uri
   * names the host, port, etc.
   *   for this FileSystem
   */
  
  BdAbstractDto getFileSystemInstance(URI uri ){
    return null;
    
  }
  /**
   * Gets the ACL of a file or directory.
   *
   * @param path Path to get
   * @return AclStatus describing the ACL of the file or directory
   * @throws IOException if an ACL could not be read
   */
  public Object getAclStatus(Path path) throws IOException {
    throw new UnsupportedOperationException(getClass().getSimpleName()
        + " doesn't support getAclStatus");
  }
  
  /**
   * Fully replaces ACL of files and directories, discarding all existing
   * entries.
   *
   * @param path Path to modify
   * @param aclSpec List<AclEntry> describing modifications, must include entries
   *   for user, group, and others for compatibility with permission bits.
   * @throws IOException if an ACL could not be modified
   */
  public void setAcl(Path path, List<Object> aclSpec) throws IOException {
    throw new UnsupportedOperationException(getClass().getSimpleName()
        + " doesn't support setAcl");
  }
  public void removeAcl(Path path)
      throws IOException {
    throw new UnsupportedOperationException(getClass().getSimpleName()
        + " doesn't support removeAcl");
  }
  
  /**
   * Removes all default ACL entries from files and directories.
   *
   * @param path Path to modify
   * @throws IOException if an ACL could not be modified
   */
  public void removeDefaultAcl(Path path)
      throws IOException {
    throw new UnsupportedOperationException(getClass().getSimpleName()
        + " doesn't support removeDefaultAcl");
  }
  
  
  public void removeAclEntries(Path path, List<Object> aclSpec)
      throws IOException {
    throw new UnsupportedOperationException(getClass().getSimpleName()
        + " doesn't support removeAclEntries");
  }
  
}
