package com.bigdinosaur.core.fs;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.bigdinosaur.core.database.BdAcl;

import com.bigdinosaur.cluster.acl.Permission;
import com.bigdinosaur.config.Configuration;



/**
 * This class provides an interface for implementors of a Hadoop file system
 * (analogous to the VFS of Unix). Applications do not access this class;
 * instead they access files across all file systems using {@link FileContext}.
 * 
 * Pathnames passed to AbstractFileSystem can be fully qualified URI that
 * matches the "this" file system (ie same scheme and authority) 
 * or a Slash-relative name that is assumed to be relative
 * to the root of the "this" file system .
 */

public abstract class BdAbstractFileSystem {
  

 
  
  private final URI myUri;
  

  
  /**
   * Returns true if the specified string is considered valid in the path part
   * of a URI by this file system.  The default implementation enforces the rules
   * of HDFS, but subclasses may override this method to implement specific
   * validation rules for specific file systems.
   * 
   * @param src String source filename to check, path part of the URI
   * @return boolean true if the specified string is considered valid
   */
  public boolean isValidName(String src) {
    StringTokenizer tokens = new StringTokenizer(src, Path.SEPARATOR);
    while(tokens.hasMoreTokens()) {
      String element = tokens.nextToken();
      if (element.equals("..") ||
          element.equals(".")  ||
          (element.indexOf(":") >= 0)) {
        return false;
      }
    }
    return true;
  }
  
  
  /** 
   * Create an object for the given class and initialize it from conf.
   * @param theClass class of which an object is created
   * @param conf Configuration
   * @return a new object
   */
  @SuppressWarnings("unchecked")
  static <T> T newInstance(Class<T> theClass,
    URI uri, Configuration conf) {
    T result = null;
    return result;
   
  }
  
  /**
   * Get the statistics for a particular file system.
   * 
   * @param uri
   *          used as key to lookup STATISTICS_TABLE. Only scheme and authority
   *          part of the uri are used.
   * @return 
   * @return a statistics object
   */
   abstract    void getStatistics(URI uri) ;
    
  
   /**
    * Prints statistics for all file systems.
    */
   public static synchronized void printStatistics()
  {
  }  /**
   * Create a file system instance for the specified uri using the conf. The
   * conf is used to find the class name that implements the file system. The
   * conf is also passed to the file system for its configuration.
   *
   * @param uri URI of the file system
   * @param conf Configuration for the file system
   * 
   * @return Returns the file system for the given URI
   *
   * @throws UnsupportedFileSystemException file system for <code>uri</code> is
   *           not found
   */
  public static BdAbstractFileSystem createFileSystem(URI uri, Configuration conf)
      {
   
    return null ;
  }


  
  private static URI getBaseUri(URI uri) {
    String scheme = uri.getScheme();
    String authority = uri.getAuthority();
    String baseUriString = scheme + "://";
    if (authority != null) {
      baseUriString = baseUriString + authority;
    } else {
      baseUriString = baseUriString + "/";
    }
    return URI.create(baseUriString);
  }
  



  


  /**
   * The main factory method for creating a file system. Get a file system for
   * the URI's scheme and authority. The scheme of the <code>uri</code>
   * determines a configuration property name,
   * <tt>fs.AbstractFileSystem.<i>scheme</i>.impl</tt> whose value names the
   * AbstractFileSystem class.
   * 
   * The entire URI and conf is passed to the AbstractFileSystem factory method.
   * 
   * @param uri for the file system to be created.
   * @param conf which is passed to the file system impl.
   * 
   * @return file system for the given URI.
   * 
   * @throws UnsupportedFileSystemException if the file system for
   *           <code>uri</code> is not supported.
   */
  public static BdAbstractFileSystem get(final URI uri, final Configuration conf)
      {
    return createFileSystem(uri, conf);
  }

  /**
   * Constructor to be called by subclasses.
   * 
   * @param uri for this file system.
   * @param supportedScheme the scheme supported by the implementor
   * @param authorityNeeded if true then theURI must have authority, if false
   *          then the URI must have null authority.
   * @throws Exception 
   *
   * @throws URISyntaxException <code>uri</code> has syntax error
   */
  public BdAbstractFileSystem(final URI uri, final String supportedScheme,
      final boolean authorityNeeded, final int defaultPort) throws Exception
      {
    myUri = getUri(uri, supportedScheme, authorityNeeded, defaultPort);
  }
  

  /**
   * Get the URI for the file system based on the given URI. The path, query
   * part of the given URI is stripped out and default file system port is used
   * to form the URI.
   * 
   * @param uri FileSystem URI.
   * @param authorityNeeded if true authority cannot be null in the URI. If
   *          false authority must be null.
   * @param defaultPort default port to use if port is not specified in the URI.
   * 
   * @return URI of the file system
   * 
   * @throws URISyntaxException <code>uri</code> has syntax error
   */
  private URI getUri(URI uri, String supportedScheme,
      boolean authorityNeeded, int defaultPort) throws Exception {
   
    String authority = uri.getAuthority();
  
    int port = uri.getPort();
    port = (port == -1 ? defaultPort : port);
    if (port == -1) { // no port supplied and default port is not specified
      return new URI(supportedScheme, authority, "/", null);
    }
    return new URI(supportedScheme + "://" + uri.getHost() + ":" + port);
  }
  
  /**
   * The default port of this file system.
   * 
   * @return default port of this file system's Uri scheme
   *         A uri with a port of -1 => default port;
   */
  public abstract int getUriDefaultPort();

  /**
   * Returns a URI whose scheme and authority identify this FileSystem.
   * 
   * @return the uri of this file system.
   */
  public URI getUri() {
    return myUri;
  }
  
  /**
   * Check that a Path belongs to this FileSystem.
   * 
   * If the path is fully qualified URI, then its scheme and authority
   * matches that of this file system. Otherwise the path must be 
   * slash-relative name.
   * @throws Exception 
   * 
   * @throws InvalidPathException if the path is invalid
   */
  public void checkPath(Path path) throws Exception {
    URI uri = path.toUri();
    String thatScheme = uri.getScheme();
    String thatAuthority = uri.getAuthority();
    if (thatScheme == null) {
      if (thatAuthority == null) {
        if (path.isAbsolute()) {
          return;
        }
        throw new Exception("relative paths not allowed:" + 
            path);
      } else {
        throw new Exception(
            "Path without scheme with non-null authority:" + path);
      }
    }
    String thisScheme = this.getUri().getScheme();
    String thisHost = this.getUri().getHost();
    String thatHost = uri.getHost();
    
    // Schemes and hosts must match.
    // Allow for null Authority for file:///
    if (!thisScheme.equalsIgnoreCase(thatScheme) ||
       (thisHost != null && 
            !thisHost.equalsIgnoreCase(thatHost)) ||
       (thisHost == null && thatHost != null)) {
      throw new Exception("Wrong FS: " + path + ", expected: "
          + this.getUri());
    }
    
    // Ports must match, unless this FS instance is using the default port, in
    // which case the port may be omitted from the given URI
    int thisPort = this.getUri().getPort();
    int thatPort = uri.getPort();
    if (thatPort == -1) { // -1 => defaultPort of Uri scheme
      thatPort = this.getUriDefaultPort();
    }
    if (thisPort != thatPort) {
      throw new Exception("Wrong FS: " + path + ", expected: "
          + this.getUri());
    }
  }
  
  /**
   * Get the path-part of a pathname. Checks that URI matches this file system
   * and that the path-part is a valid name.
   * 
   * @param p path
   * 
   * @return path-part of the Path p
   * @throws Exception 
   */
  public String getUriPath(final Path p) throws Exception {
    checkPath(p);
    String s = p.toUri().getPath();
    if (!isValidName(s)) {
      throw new Exception("Path part " + s + " from URI " + p
          + " is not a valid filename.");
    }
    return s;
  }
  
  /**
   * Make the path fully qualified to this file system
   * @param path
   * @return the qualified path
   * @throws Exception 
   */
  public Path makeQualified(Path path) throws Exception {
    checkPath(path);
//    return path.make (this.getUri(), null);
    return path;
  }
  
  /**
   * Some file systems like LocalFileSystem have an initial workingDir
   * that is used as the starting workingDir. For other file systems
   * like HDFS there is no built in notion of an initial workingDir.
   * 
   * @return the initial workingDir if the file system has such a notion
   *         otherwise return a null.
   */
  public Path getInitialWorkingDirectory() {
    return null;
  }
  
  /** 
   * Return the current user's home directory in this file system.
   * The default implementation returns "/user/$USER/".
   * 
   * @return current user's home directory.
   */
  public Path getHomeDirectory() {
    return new Path("/user/"+System.getProperty("user.name")).makeQualified(
                                                                getUri(), null);
  }
  
  /**
   * Return a set of server default configuration values.
   * 
   * @return server default configuration values
   * 
   * @throws IOException an I/O error occurred
   */
  public abstract Object getServerDefaults() throws IOException; 
  
  /**
   * The specification of this method matches that of
   * {@link FileContext#create(Path, EnumSet, Options.CreateOpts...)} except
   * that the Path f must be fully qualified and the permission is absolute
   * (i.e. umask has been applied).
   */
  public abstract DataOutputStream create(final Path path );
      

//    return this.createInternal(f, createFlag, permission, bufferSize,
//      replication, blockSize, progress, checksumOpt, createParent);

  /**
   * The specification of this method matches that of
   * {@link #create(Path, EnumSet, Options.CreateOpts...)} except that the opts
   * have been declared explicitly.
   */
  public abstract DataOutputStream createInternal(Path f);

  /**
   * The specification of this method matches that of
   * {@link FileContext#mkdir(Path, FsPermission, boolean)} except that the Path
   * f must be fully qualified and the permission is absolute (i.e. 
   * umask has been applied).
   */
  public abstract void mkdir(final Path dir, final Permission permission,
      final boolean createParent);

  /**
   * The specification of this method matches that of
   * {@link FileContext#delete(Path, boolean)} except that Path f must be for
   * this file system.
   */
  public abstract boolean delete(final Path f, final boolean recursive);
     

  /**
   * The specification of this method matches that of
   * {@link FileContext#open(Path)} except that Path f must be for this
   * file system.
   */
  public abstract DataInputStream open(final Path f);

  /**
   * The specification of this method matches that of
   * {@link FileContext#open(Path, int)} except that Path f must be for this
   * file system.
   */
  public abstract DataInputStream open(final Path f, int bufferSize);
    

  /**
   * The specification of this method matches that of
   * {@link FileContext#setReplication(Path, short)} except that Path f must be
   * for this file system.
   */
  public abstract boolean setReplication(final Path f, final short replication) ;
     

  /**
   * The specification of this method matches that of
   * {@link FileContext#rename(Path, Path, Options.Rename...)} except that Path
   * f must be for this file system.
   */
  public abstract  void rename( Path src, final Path dst);
  
  /**
   * The specification of this method matches that of
   * {@link FileContext#rename(Path, Path, Options.Rename...)} except that Path
   * f must be for this file system and NO OVERWRITE is performed.
   * 
   * File systems that do not have a built in overwrite need implement only this
   * method and can take advantage of the default impl of the other
   * {@link #renameInternal(Path, Path, boolean)}
   */
  public abstract void renameInternal(final Path src, final Path dst);
      
  
  /**
   * The specification of this method matches that of
   * {@link FileContext#rename(Path, Path, Options.Rename...)} except that Path
   * f must be for this file system.
   */
  public abstract void renameInternal(final Path src, final Path dst,
      boolean overwrite);
  
  /**
   * Returns true if the file system supports symlinks, false otherwise.
   * @return true if filesystem supports symlinks
   */
  public boolean supportsSymlinks() {
    return false;
  }
  
  /**
   * The specification of this method matches that of  
   * {@link FileContext#createSymlink(Path, Path, boolean)};
   */
  public abstract void createSymlink(final Path target, final Path link,
      final boolean createParent);

 
    
  /**
   * The specification of this method matches that of
   * {@link FileContext#setPermission(Path, FsPermission)} except that Path f
   * must be for this file system.
   */
  public abstract void setPermission(final Path f,
      final Permission permission) ;
  /**
   * The specification of this method matches that of
   * {@link FileContext#setOwner(Path, String, String)} except that Path f must
   * be for this file system.
   */
  public abstract void setOwner(final Path f, final String username,
      final String groupname) ;

  /**
   * The specification of this method matches that of
   * {@link FileContext#setTimes(Path, long, long)} except that Path f must be
   * for this file system.
   */
  public abstract void setTimes(final Path f, final long mtime,
    final long atime) ;

  /**
   * The specification of this method matches that of
   * {@link FileContext#getFileChecksum(Path)} except that Path f must be for
   * this file system.
   */
  public abstract Object getFileChecksum(final Path f);
    
  
  /**
   * The specification of this method matches that of
   * {@link FileContext#getFileStatus(Path)} 
   * except that an UnresolvedLinkException may be thrown if a symlink is 
   * encountered in the path.
   */
  public abstract Object getFileStatus(final Path f);


  /**
   * The specification of this method matches that of
   * {@link FileContext#getFileLinkStatus(Path)}
   * except that an UnresolvedLinkException may be thrown if a symlink is  
   * encountered in the path leading up to the final path component.
   * If the file system does not support symlinks then the behavior is
   * equivalent to {@link AbstractFileSystem#getFileStatus(Path)}.
   */
  public abstract Object getFileLinkStatus(final Path f);

  /**
   * The specification of this method matches that of
   * {@link FileContext#getFileBlockLocations(Path, long, long)} except that
   * Path f must be for this file system.
   */
  public abstract Object[] getFileBlockLocations(final Path f,
      final long start, final long len) ;

  /**
   * The specification of this method matches that of
   * {@link FileContext#getFsStatus(Path)} except that Path f must be for this
   * file system.
   */
  public abstract Object getFsStatus(final Path f) ;
  
  /**
   * The specification of this method matches that of
   * {@link FileContext#getFsStatus(Path)}.
   */
  public abstract Object getFsStatus();

  /**
   * The specification of this method matches that of
   * {@link FileContext#listStatus(Path)} except that Path f must be for this
   * file system.
   */
  public abstract Object listStatusIterator(final Path f);
      

  /**
   * The specification of this method matches that of
   * {@link FileContext#listLocatedStatus(Path)} except that Path f 
   * must be for this file system.
   */
  // in all remote directories 
  public abstract Object listLocatedStatus(final Path f);
      

  /**
   * The specification of this method matches that of
   * {@link FileContext.Util#listStatus(Path)} except that Path f must be 
   * for this file system.
   */
  public abstract Object[] listStatus(final Path f);
     

  /**
   * @return an iterator over the corrupt files under the given path
   * (may contain duplicates if a file has more than one corrupt block)
   * @throws IOException
   */
  public List<Object> listCorruptFileBlocks(Path path)
    throws IOException {
    throw new UnsupportedOperationException(getClass().getCanonicalName() +
                                            " does not support" +
                                            " listCorruptFileBlocks");
  }

  /**
   * The specification of this method matches that of
   * {@link FileContext#setVerifyChecksum(boolean, Path)} except that Path f
   * must be for this file system.
   */
  public abstract void setVerifyChecksum(final boolean verifyChecksum);
     
  
  /**
   * Get a canonical name for this file system.
   * @return a URI string that uniquely identifies this file system
   */
  public abstract String getCanonicalServiceName();
   

  
  /**
   * Get one or more delegation tokens associated with the filesystem. Normally
   * a file system returns a single delegation token. A file system that manages
   * multiple file systems underneath, could return set of delegation tokens for
   * all the file systems it manages
   * 
   * @param renewer the account name that is allowed to renew the token.
   * @return List of delegation tokens.
   *   If delegation tokens not supported then return a list of size zero.
   * @throws IOException
   */
  public abstract List<Object> getDelegationTokens(String renewer) throws IOException ;
    

  /**
   * Modifies ACL entries of files and directories.  This method can add new ACL
   * entries or modify the permissions on existing ACL entries.  All existing
   * ACL entries that are not specified in this call are retained without
   * changes.  (Modifications are merged into the current ACL.)
   *
   * @param path Path to modify
   * @param aclSpec List<AclEntry> describing modifications
   * @throws IOException if an ACL could not be modified
   */
  public void modifyAclEntries(Path path, List<BdAcl> aclSpec)
      throws IOException {
    throw new UnsupportedOperationException(getClass().getSimpleName()
        + " doesn't support modifyAclEntries");
  }

  /**
   * Removes ACL entries from files and directories.  Other ACL entries are
   * retained.
   *
   * @param path Path to modify
   * @param aclSpec List<AclEntry> describing entries to remove
   * @throws IOException if an ACL could not be modified
   */
  public void removeAclEntries(Path path, List<BdAcl> aclSpec)
      throws IOException {
    throw new UnsupportedOperationException(getClass().getSimpleName()
        + " doesn't support removeAclEntries");
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

  /**
   * Removes all but the base ACL entries of files and directories.  The entries
   * for user, group, and others are retained for compatibility with permission
   * bits.
   *
   * @param path Path to modify
   * @throws IOException if an ACL could not be removed
   */
  public void removeAcl(Path path)
      throws IOException {
    throw new UnsupportedOperationException(getClass().getSimpleName()
        + " doesn't support removeAcl");
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
  public void setAcl(Path path, List<BdAcl> aclSpec) throws IOException {
    throw new UnsupportedOperationException(getClass().getSimpleName()
        + " doesn't support setAcl");
  }

  /**
   * Gets the ACLs of files and directories.
   *
   * @param path Path to get
   * @return RemoteIterator<AclStatus> which returns each AclStatus
   * @throws IOException if an ACL could not be read
   */
  public BdAcl getAclStatus(Path path) throws IOException {
    throw new UnsupportedOperationException(getClass().getSimpleName()
        + " doesn't support getAclStatus");
  }

  /**
   * Set an xattr of a file or directory.
   * The name must be prefixed with the namespace followed by ".". For example,
   * "user.attr".
   * <p/>
   * Refer to the HDFS extended attributes user documentation for details.
   *
   * @param path Path to modify
   * @param name xattr name.
   * @param value xattr value.
   * @throws IOException
   */
  public void setXAttr(Path path, String name, byte[] value)
      throws IOException {
  }

 

  /**
   * Get an xattr for a file or directory.
   * The name must be prefixed with the namespace followed by ".". For example,
   * "user.attr".
   * <p/>
   * Refer to the HDFS extended attributes user documentation for details.
   *
   * @param path Path to get extended attribute
   * @param name xattr name.
   * @return byte[] xattr value.
   * @throws IOException
   */
  public byte[] getXAttr(Path path, String name) throws IOException {
    throw new UnsupportedOperationException(getClass().getSimpleName()
        + " doesn't support getXAttr");
  }

  /**
   * Get all of the xattrs for a file or directory.
   * Only those xattrs for which the logged-in user has permissions to view
   * are returned.
   * <p/>
   * Refer to the HDFS extended attributes user documentation for details.
   *
   * @param path Path to get extended attributes
   * @return Map<String, byte[]> describing the XAttrs of the file or directory
   * @throws IOException
   */
  public Map<String, byte[]> getXAttrs(Path path) throws IOException {
    throw new UnsupportedOperationException(getClass().getSimpleName()
        + " doesn't support getXAttrs");
  }

  /**
   * Get all of the xattrs for a file or directory.
   * Only those xattrs for which the logged-in user has permissions to view
   * are returned.
   * <p/>
   * Refer to the HDFS extended attributes user documentation for details.
   *
   * @param path Path to get extended attributes
   * @param names XAttr names.
   * @return Map<String, byte[]> describing the XAttrs of the file or directory
   * @throws IOException
   */
  public Map<String, byte[]> getXAttrs(Path path, List<String> names)
      throws IOException {
    throw new UnsupportedOperationException(getClass().getSimpleName()
        + " doesn't support getXAttrs");
  }

  /**
   * Get all of the xattr names for a file or directory.
   * Only the xattr names for which the logged-in user has permissions to view
   * are returned.
   * <p/>
   * Refer to the HDFS extended attributes user documentation for details.
   *
   * @param path Path to get extended attributes
   * @return Map<String, byte[]> describing the XAttrs of the file or directory
   * @throws IOException
   */
  public List<String> listXAttrs(Path path)
          throws IOException {
    throw new UnsupportedOperationException(getClass().getSimpleName()
            + " doesn't support listXAttrs");
  }

  /**
   * Remove an xattr of a file or directory.
   * The name must be prefixed with the namespace followed by ".". For example,
   * "user.attr".
   * <p/>
   * Refer to the HDFS extended attributes user documentation for details.
   *
   * @param path Path to remove extended attribute
   * @param name xattr name
   * @throws IOException
   */
  public void removeXAttr(Path path, String name) throws IOException {
    throw new UnsupportedOperationException(getClass().getSimpleName()
        + " doesn't support removeXAttr");
  }

  @Override //Object
  public int hashCode() {
    return myUri.hashCode();
  }
  
  @Override //Object
  public boolean equals(Object other) {
    if (other == null || !(other instanceof BdAbstractFileSystem)) {
      return false;
    }
    return myUri.equals(((BdAbstractFileSystem) other).myUri);
  }
}
