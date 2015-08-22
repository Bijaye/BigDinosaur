package com.bigdinosaur.core.fs;



import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.security.AccessControlException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.bigdinosaur.cluster.acl.FsPermission;
import com.bigdinosaur.config.Configuration;
import com.bigdinosaur.config.Configured;

/****************************************************************
 * An abstract base class for a fairly generic filesystem.  It
 * may be implemented as a distributed filesystem, or as a "local"
 * one that reflects the locally-connected disk.  The local version
 * exists for small Hadoop instances and for testing.
 *
 * <p>
 *
 * All user code that may potentially use the Hadoop Distributed
 * File System should be written to use a FileSystem object.  The
 * Hadoop DFS is a multi-machine system that appears as a single
 * disk.  It's useful because of its fault tolerance and potentially
 * very large capacity.
 * 
 * <p>
 * The local implementation is {@link LocalFileSystem} and distributed
 * implementation is DistributedFileSystem.
 *****************************************************************/

public abstract class FileSystem extends Configured implements Closeable {
  /**
   * A cache of files that should be deleted when filsystem is closed
   * or the JVM is exited.
   */
  private Set<Path> deleteOnExit = new TreeSet<Path>();
  
  final FileSystem[]  getChildFileSystems(){
    FileSystem[] children = null;
  if (children != null) {
    for (final FileSystem fs : children) {
     
    }
  }
  return children;
  }
  
  /**
   * Create an FSDataOutputStream at the indicated Path.
   * Files are overwritten by default.
   * @param f the file to create
   */
  public DataOutputStream create(Path f) throws IOException {
    return null;
    
  }

  /**
   * Create an FSDataOutputStream at the indicated Path.
   * @param f the file name to create
   * @param overwrite if a file with this name already exists, then if true,
   *   the file will be overwritten, and if false an error will be thrown.
   * @param bufferSize the size of the buffer to be used.
   */
  public DataOutputStream create(Path f, 
                                   boolean overwrite,
                                   int bufferSize
                                   ) throws IOException {
    return create(f, overwrite, bufferSize, 
                  getDefaultReplication(f),
                  getDefaultBlockSize(f));
  }
  
  /**
   * Create an FSDataOutputStream at the indicated Path.
   * @param f the file name to open
   * @param overwrite if a file with this name already exists, then if true,
   *   the file will be overwritten, and if false an error will be thrown.
   * @param bufferSize the size of the buffer to be used.
   * @param replication required block replication for the file. 
   */
  public DataOutputStream create(Path f, 
                                   boolean overwrite,
                                   int bufferSize,
                                   short replication,
                                   long blockSize
                                   ) throws IOException {
                                    return null;
//    return create(f, overwrite, bufferSize, replication, blockSize, null);
  }
  
  
  public abstract DataOutputStream create(Path f,
                                            FsPermission permission,
                                            boolean overwrite,
                                            int bufferSize,
                                            short replication,
                                            long blockSize,
                                            Object progress) throws IOException;
  
  /**
   * Create an FSDataOutputStream at the indicated Path with write-progress
   * reporting.
   * @param f the path of the file to open
   * @param overwrite if a file with this name already exists, then if true,
   *   the file will be overwritten, and if false an error will be thrown.
   * @param bufferSize the size of the buffer to be used.
   */
  public DataOutputStream create(Path f, 
                                   boolean overwrite,
                                   int bufferSize,
                                   Object progress
                                   ) throws IOException {
                                    return null;
//    return create(f, overwrite, bufferSize, 
//                  getDefaultReplication(f),
//                  getDefaultBlockSize(f), progress);
  }
  
  /** create a directory with the provided permission
   * The permission of the directory is set to be the provided permission as in
   * setPermission, not permission&~umask
   * 
   * @see #create(FileSystem, Path, FsPermission)
   * 
   * @param fs file system handle
   * @param dir the name of the directory to be created
   * @param permission the permission of the directory
   * @return true if the directory creation succeeds; false otherwise
   * @throws IOException
   */
  public static boolean mkdirs(FileSystem fs, Path dir, FsPermission permission)
  throws IOException {
    boolean result = false;
    // create the directory using the default permission
//    boolean result = fs.mkdirs(dir);
    // set its permission to be the supplied one
//    fs.setPermission(dir, permission);
    return result;
  }
  
  
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
  
  
  
  
  
  
  public abstract URI getUri();

  public abstract Path getWorkingDirectory();
  public static FileSystem get(URI uri, Configuration conf) throws Exception{
    Key key = new Key();
    return getInternal(uri, conf, key);
  }
  
  public static FileSystem getInternal(URI uri, Configuration conf, Key key) throws IOException
  {
    return null;
  }
    
  
}
