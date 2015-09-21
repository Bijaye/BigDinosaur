package com.bigdinosaur.core.fs;

import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.AccessControlException;
import java.security.PrivilegedExceptionAction;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.bigdinosaur.cluster.acl.FsPermission;
import com.bigdinosaur.config.BdConfiguration;
import com.bigdinosaur.config.CommonConfigurationKeys;
import com.bigdinosaur.config.Configured;
import com.bigdinosaur.config.UserGroupInformation;
import com.bigdinosaur.core.io.FSDataInputStream;
import com.bigdinosaur.core.io.FSDataOutputStream;

/****************************************************************
 * An abstract base class for a fairly generic filesystem. It may be implemented as a distributed
 * filesystem, or as a "local" one that reflects the locally-connected disk. The local version
 * exists for small Hadoop instances and for testing.
 *
 * <p>
 *
 * All user code that may potentially use the Hadoop Distributed File System should be written to
 * use a FileSystem object. The Hadoop DFS is a multi-machine system that appears as a single disk.
 * It's useful because of its fault tolerance and potentially very large capacity.
 * 
 * <p>
 * The local implementation is {@link LocalFileSystem} and distributed implementation is
 * DistributedFileSystem.
 *****************************************************************/

public abstract class FileSystem
    extends Configured
    implements Closeable
{
  
  public static final String FS_DEFAULT_NAME_KEY =   CommonConfigurationKeys.FS_DEFAULT_NAME_KEY;
  
    
public static final String DEFAULT_FS =  CommonConfigurationKeys.FS_DEFAULT_NAME_DEFAULT;
     
  
  // data is stored on the basis of key and Filesystem
  // key contains uri and configuration

  private final static Map<Key, FileSystem> map = new HashMap<Key, FileSystem>();

  /**
   * A cache of files that should be deleted when filsystem is closed or the JVM is exited.
   */
  private Set<Path> deleteOnExit = new TreeSet<Path>();

  final FileSystem[] getChildFileSystems()
  {
    FileSystem[] children = null;
    if (children != null)
    {
      for (final FileSystem fs : children)
      {

      }
    }
    return children;
  }

  /**
   * Create an FSDataOutputStream at the indicated Path. Files are overwritten by default.
   * 
   * @param f
   *          the file to create
   */
  public DataOutputStream create(Path f) throws IOException
  {
    return null;

  }

  public FileSystem getFileSystem(URI uri) throws Exception
  {
    return FileSystem.get(uri, getConf());
  }

  /**
   * Create an FSDataOutputStream at the indicated Path.
   * 
   * @param f
   *          the file name to create
   * @param overwrite
   *          if a file with this name already exists, then if true, the file will be overwritten,
   *          and if false an error will be thrown.
   * @param bufferSize
   *          the size of the buffer to be used.
   */
  public DataOutputStream create(Path f, boolean overwrite, int bufferSize) throws IOException
  {
    return create(f, overwrite, bufferSize, getDefaultReplication(f), getDefaultBlockSize(f));
  }

  /**
   * Create an FSDataOutputStream at the indicated Path.
   * 
   * @param f
   *          the file name to open
   * @param overwrite
   *          if a file with this name already exists, then if true, the file will be overwritten,
   *          and if false an error will be thrown.
   * @param bufferSize
   *          the size of the buffer to be used.
   * @param replication
   *          required block replication for the file.
   */
  public DataOutputStream create(Path f, boolean overwrite, int bufferSize, short replication,
                                 long blockSize) throws IOException
  {
    return null;
    // return create(f, overwrite, bufferSize, replication, blockSize, null);
  }

  public abstract DataOutputStream create(Path f, FsPermission permission, boolean overwrite,
                                          int bufferSize, short replication, long blockSize,
                                          Object progress) throws IOException;

  /**
   * Create an FSDataOutputStream at the indicated Path with write-progress reporting.
   * 
   * @param f
   *          the path of the file to open
   * @param overwrite
   *          if a file with this name already exists, then if true, the file will be overwritten,
   *          and if false an error will be thrown.
   * @param bufferSize
   *          the size of the buffer to be used.
   */
  public DataOutputStream create(Path f, boolean overwrite, int bufferSize, Object progress)
                                                                                            throws IOException
  {
    return null;
    // return create(f, overwrite, bufferSize,
    // getDefaultReplication(f),
    // getDefaultBlockSize(f), progress);
  }

  /**
   * create a directory with the provided permission The permission of the directory is set to be
   * the provided permission as in setPermission, not permission&~umask
   * 
   * @see #create(FileSystem, Path, FsPermission)
   * 
   * @param fs
   *          file system handle
   * @param dir
   *          the name of the directory to be created
   * @param permission
   *          the permission of the directory
   * @return true if the directory creation succeeds; false otherwise
   * @throws IOException
   */
  public static boolean mkdirs(FileSystem fs, Path dir, FsPermission permission) throws IOException
  {
    // create the directory using the default permission
     boolean result = fs.mkdirs(dir);
    // set its permission to be the supplied one
    // fs.setPermission(dir, permission);
    return result;
  }

  /** Return the total size of all files in the filesystem. */
  public long getUsed() throws IOException
  {
    long used = 0;
    FileStatus[] files = new FileStatus[11];
    for (FileStatus file : files)
    {
      used += file.getLen();
    }
    return used;
  }

  /**
   * Get the block size for a particular file.
   * 
   * @param f
   *          the filename
   * @return the number of bytes in a block
   */
  public long getBlockSize(Path f) throws IOException
  {
    return 222;
  }

  /**
   * Return the number of bytes that large input files should be optimally be split into to minimize
   * i/o time.
   * 
   */
  public long getDefaultBlockSize()
  {
    // default to 32MB: large enough to minimize the impact of seeks
    return 4000;
  }

  /**
   * Get the default replication for a path. The given path will be used to locate the actual
   * filesystem. The full path does not have to exist.
   * 
   * @param path
   *          of the file
   * @return default replication for the path's filesystem
   */
  public short getDefaultReplication(Path path)
  {
    return 20;
  }
  public short getDefaultReplication() { return 1; }

  /**
   * Return the number of bytes that large input files should be optimally be split into to minimize
   * i/o time. The given path will be used to locate the actual filesystem. The full path does not
   * have to exist.
   * 
   * @param f
   *          path of file
   * @return the default block size for the path's filesystem
   */
  public long getDefaultBlockSize(Path f)
  {
    return 20;
  }

  /**
   * Checks if the user can access a path. The mode specifies which access checks to perform. If the
   * requested permissions are granted, then the method returns normally. If access is denied, then
   * the method throws an AccessControlException
   * 
   * The default implementation of this method calls getFileStatus(Path) and checks the returned
   * permissions against the requested permissions. Note that the getFileStatus call will be subject
   * to authorization checks. Typically, this requires search (execute) permissions on each
   * directory in the path's prefix, but this is implementation-defined. Any file system that
   * provides a richer authorization model (such as ACLs) may override the default implementation so
   * that it checks against that model instead.
   * 
   * In general, applications should avoid using this method, due to the risk of
   * time-of-check/time-of-use race conditions. The permissions on a file may change immediately
   * after the access call returns. Most applications should prefer running specific file system
   * actions as the desired user represented by a UserGroupInformation
   *
   * @param path
   *          Path to check
   * @param mode
   *          type of access to check
   * @throws AccessControlException
   *           if access is denied
   * @throws FileNotFoundException
   *           if the path does not exist
   * @throws IOException
   *           see specific implementation
   */

  public void hasaccess(Path path, Object mode) throws AccessControlException,
                                               FileNotFoundException, IOException
  {

  }

  /**
   * Get the checksum of a file, from the beginning of the file till the specific length.
   * 
   * @param f
   *          The file path
   * @param length
   *          The length of the file range for checksum calculation
   * @return The file checksum.
   */
  public Object getFileChecksum(Path f, final long length) throws IOException
  {
    return null;
  }

  /**
   * Get a filesystem instance based on the uri names the host, port, etc. for this FileSystem
   */

  BdAbstractDto getFileSystemInstance(URI uri)
  {
    return null;

  }

  // get the filesystem based on uri
  public static FileSystem get(URI uri, BdConfiguration conf) throws IOException
  {
    Key key = new Key(uri, conf);
    return getInternal(uri, conf, key);
  }

  /**
   * Gets the ACL of a file or directory.
   *
   * @param path
   *          Path to get
   * @return AclStatus describing the ACL of the file or directory
   * @throws IOException
   *           if an ACL could not be read
   */
  public Object getAclStatus(Path path) throws IOException
  {
    throw new UnsupportedOperationException(getClass().getSimpleName() +
        " doesn't support getAclStatus");
  }

  /**
   * Fully replaces ACL of files and directories, discarding all existing entries.
   *
   * @param path
   *          Path to modify
   * @param aclSpec
   *          List<AclEntry> describing modifications, must include entries for user, group, and
   *          others for compatibility with permission bits.
   * @throws IOException
   *           if an ACL could not be modified
   */
  public void setAcl(Path path, List<Object> aclSpec) throws IOException
  {
    throw new UnsupportedOperationException(getClass().getSimpleName() + " doesn't support setAcl");
  }

  public void removeAcl(Path path) throws IOException
  {
    throw new UnsupportedOperationException(getClass().getSimpleName() +
        " doesn't support removeAcl");
  }

  /**
   * Removes all default ACL entries from files and directories.
   *
   * @param path
   *          Path to modify
   * @throws IOException
   *           if an ACL could not be modified
   */
  public void removeDefaultAcl(Path path) throws IOException
  {
    throw new UnsupportedOperationException(getClass().getSimpleName() +
        " doesn't support removeDefaultAcl");
  }

  public void removeAclEntries(Path path, List<Object> aclSpec) throws IOException
  {
    throw new UnsupportedOperationException(getClass().getSimpleName() +
        " doesn't support removeAclEntries");
  }

  public abstract URI getUri();

  public abstract Path getWorkingDirectory();


  public static FileSystem get(final URI uri, final BdConfiguration conf,
                               final String user) throws IOException, InterruptedException {
                           String ticketCachePath ="";
                           
                           UserGroupInformation ugi =
                               UserGroupInformation.getBestUGI(ticketCachePath, user);
                           return (FileSystem) ugi.doAs(new PrivilegedExceptionAction<FileSystem>() {
                             @Override
                             public FileSystem run() throws Exception {
                               return get(uri, conf);
                             }
                           });
                         }

  public static FileSystem getInternal(URI uri, BdConfiguration conf, Key key) throws IOException
  {
    FileSystem fs;
      fs = map.get(key);
    if (fs != null)
    {
      return fs;
    }
    return fs;
  }

  /**
   * Get the local file system.
   * 
   * @param conf
   *          the configuration to configure the file system with
   * @return a LocalFileSystem
   * @throws Exception 
   */
  public static BdLocalFileSystem getLocal(BdConfiguration conf) throws Exception
  {
    return (BdLocalFileSystem) get(BdLocalFileSystem.NAME, conf);
  }

  
  public Path makeQualified(Path path) {
    checkPath(path);
    return path.makeQualified(this.getUri(), this.getWorkingDirectory());
  }
  
  
  protected void checkPath(Path path) {
    URI uri = path.toUri();
    String thatScheme = uri.getScheme();
    if (thatScheme == null)                // fs is relative
      return;
    URI thisUri = getCanonicalUri();
    String thisScheme = thisUri.getScheme();
    //authority and scheme are not case sensitive
    if (thisScheme.equalsIgnoreCase(thatScheme)) {// schemes match
      String thisAuthority = thisUri.getAuthority();
      String thatAuthority = uri.getAuthority();
      if (thatAuthority == null &&                // path's authority is null
          thisAuthority != null) {                // fs has an authority
        URI defaultUri = getDefaultUri(getConf());
        if (thisScheme.equalsIgnoreCase(defaultUri.getScheme())) {
          uri = defaultUri; // schemes match, so use this uri instead
        } else {
          uri = null; // can't determine auth of the path
        }
      }
      if (uri != null) {
        // canonicalize uri before comparing with this fs
        uri = canonicalizeUri(uri);
        thatAuthority = uri.getAuthority();
        if (thisAuthority == thatAuthority ||       // authorities match
            (thisAuthority != null &&
             thisAuthority.equalsIgnoreCase(thatAuthority)))
          return;
      }
    }
    throw new IllegalArgumentException("Wrong FS: "+path+
                                       ", expected: "+this.getUri());
  }
  protected URI getCanonicalUri() {
    return canonicalizeUri(getUri());
  }
  protected URI canonicalizeUri(URI uri) {
    if (uri.getPort() == -1 && getDefaultPort() > 0) {
      // reconstruct the uri with the default port set
      try {
        uri = new URI(uri.getScheme(), uri.getUserInfo(),
            uri.getHost(), getDefaultPort(),
            uri.getPath(), uri.getQuery(), uri.getFragment());
      } catch (URISyntaxException e) {
        // Should never happen!
        throw new AssertionError("Valid URI became unparseable: " +
            uri);
      }
    }
    
    return uri;
  }
  
  protected int getDefaultPort() {
    return 0;
  }
  public static URI getDefaultUri(BdConfiguration conf) {
    return URI.create(fixName(conf.get(FS_DEFAULT_NAME_KEY, DEFAULT_FS)));
  }
  public boolean mkdirs(Path f) throws IOException {
    return mkdirs(f, FsPermission.getDefault());
  }
  /**
   * Make the given file and all non-existent parents into
   * directories. Has the semantics of Unix 'mkdir -p'.
   * Existence of the directory hierarchy is not an error.
   * @param f path to create
   * @param permission to apply to f
   */
  public abstract boolean mkdirs(Path f, FsPermission permission
      ) throws IOException;

  private static String fixName(String name) {
    return name;
  }
  
  @Deprecated
  public boolean delete(Path f) throws IOException {
    return delete(f, true);
  }
  
  /** Delete a file.
   *
   * @param f the path to delete.
   * @param recursive if path is a directory and set to 
   * true, the directory is deleted else throws an exception. In
   * case of a file the recursive can be set to either true or false. 
   * @return  true if delete is successful else false. 
   * @throws IOException
   */
  public abstract boolean delete(Path f, boolean recursive) throws IOException;

  public abstract FileStatus getFileStatus(Path f) throws IOException;
  
  /**
   * List the statuses of the files/directories in the given path if the path is
   * a directory.
   * 
   * @param f given path
   * @return the statuses of the files/directories in the given patch
   * @throws FileNotFoundException when the path does not exist;
   *         IOException see specific implementation
   */
  public abstract FileStatus[] listStatus(Path f) throws FileNotFoundException, 
                                                         IOException;
  public FSDataInputStream open(Path f) throws IOException {
    return open(f, getConf().getInt("io.file.buffer.size", 4096));
  }
  public abstract FSDataInputStream open(Path f, int bufferSize)
      throws IOException;
  public boolean exists(Path f) throws IOException {
    try {
      return getFileStatus(f) != null;
    } catch (FileNotFoundException e) {
      return false;
    }
  }

  public FSDataOutputStream create(Path f, boolean overwrite)
      throws IOException {
      return (FSDataOutputStream) create(f, overwrite, 
                    getConf().getInt("io.file.buffer.size", 4096),
                    getDefaultReplication(),
                    getDefaultBlockSize());
    }
  public static final class Statistics {
    /**
     * Statistics data.
     * 
     * There is only a single writer to thread-local StatisticsData objects.
     * Hence, volatile is adequate here-- we do not need AtomicLong or similar
     * to prevent lost updates.
     * The Java specification guarantees that updates to volatile longs will
     * be perceived as atomic with respect to other threads, which is all we
     * need.
     */
    public static class StatisticsData {
      volatile long bytesRead;
      volatile long bytesWritten;
      volatile int readOps;
      volatile int largeReadOps;
      volatile int writeOps;
      /**
       * Stores a weak reference to the thread owning this StatisticsData.
       * This allows us to remove StatisticsData objects that pertain to
       * threads that no longer exist.
       */
      final WeakReference<Thread> owner;

      StatisticsData(WeakReference<Thread> owner) {
        this.owner = owner;
      }

      /**
       * Add another StatisticsData object to this one.
       */
      void add(StatisticsData other) {
        this.bytesRead += other.bytesRead;
        this.bytesWritten += other.bytesWritten;
        this.readOps += other.readOps;
        this.largeReadOps += other.largeReadOps;
        this.writeOps += other.writeOps;
      }

      /**
       * Negate the values of all statistics.
       */
      void negate() {
        this.bytesRead = -this.bytesRead;
        this.bytesWritten = -this.bytesWritten;
        this.readOps = -this.readOps;
        this.largeReadOps = -this.largeReadOps;
        this.writeOps = -this.writeOps;
      }

      @Override
      public String toString() {
        return bytesRead + " bytes read, " + bytesWritten + " bytes written, "
            + readOps + " read ops, " + largeReadOps + " large read ops, "
            + writeOps + " write ops";
      }
      
      public long getBytesRead() {
        return bytesRead;
      }
      
      public long getBytesWritten() {
        return bytesWritten;
      }
      
      public int getReadOps() {
        return readOps;
      }
      
      public int getLargeReadOps() {
        return largeReadOps;
      }
      
      public int getWriteOps() {
        return writeOps;
      }
    }

    private interface StatisticsAggregator<T> {
      void accept(StatisticsData data);
      T aggregate();
    }

    private final String scheme;

    /**
     * rootData is data that doesn't belong to any thread, but will be added
     * to the totals.  This is useful for making copies of Statistics objects,
     * and for storing data that pertains to threads that have been garbage
     * collected.  Protected by the Statistics lock.
     */
    private final StatisticsData rootData;

    /**
     * Thread-local data.
     */
    private final ThreadLocal<StatisticsData> threadData;
    
    /**
     * List of all thread-local data areas.  Protected by the Statistics lock.
     */
    private LinkedList<StatisticsData> allData;

    public Statistics(String scheme) {
      this.scheme = scheme;
      this.rootData = new StatisticsData(null);
      this.threadData = new ThreadLocal<StatisticsData>();
      this.allData = null;
    }

    /**
     * Copy constructor.
     * 
     * @param other    The input Statistics object which is cloned.
     */
    public Statistics(Statistics other) {
      this.scheme = other.scheme;
      this.rootData = new StatisticsData(null);
      other.visitAll(new StatisticsAggregator<Void>() {
        @Override
        public void accept(StatisticsData data) {
          rootData.add(data);
        }

        public Void aggregate() {
          return null;
        }
      });
      this.threadData = new ThreadLocal<StatisticsData>();
    }

    /**
     * Get or create the thread-local data associated with the current thread.
     */
    public StatisticsData getThreadStatistics() {
      StatisticsData data = threadData.get();
      if (data == null) {
        data = new StatisticsData(
            new WeakReference<Thread>(Thread.currentThread()));
        threadData.set(data);
        synchronized(this) {
          if (allData == null) {
            allData = new LinkedList<StatisticsData>();
          }
          allData.add(data);
        }
      }
      return data;
    }

    /**
     * Increment the bytes read in the statistics
     * @param newBytes the additional bytes read
     */
    public void incrementBytesRead(long newBytes) {
      getThreadStatistics().bytesRead += newBytes;
    }
    
    /**
     * Increment the bytes written in the statistics
     * @param newBytes the additional bytes written
     */
    public void incrementBytesWritten(long newBytes) {
      getThreadStatistics().bytesWritten += newBytes;
    }
    
    /**
     * Increment the number of read operations
     * @param count number of read operations
     */
    public void incrementReadOps(int count) {
      getThreadStatistics().readOps += count;
    }

    /**
     * Increment the number of large read operations
     * @param count number of large read operations
     */
    public void incrementLargeReadOps(int count) {
      getThreadStatistics().largeReadOps += count;
    }

    /**
     * Increment the number of write operations
     * @param count number of write operations
     */
    public void incrementWriteOps(int count) {
      getThreadStatistics().writeOps += count;
    }

    /**
     * Apply the given aggregator to all StatisticsData objects associated with
     * this Statistics object.
     *
     * For each StatisticsData object, we will call accept on the visitor.
     * Finally, at the end, we will call aggregate to get the final total. 
     *
     * @param         The visitor to use.
     * @return        The total.
     */
    private synchronized <T> T visitAll(StatisticsAggregator<T> visitor) {
      visitor.accept(rootData);
      if (allData != null) {
        for (Iterator<StatisticsData> iter = allData.iterator();
            iter.hasNext(); ) {
          StatisticsData data = iter.next();
          visitor.accept(data);
          if (data.owner.get() == null) {
            /*
             * If the thread that created this thread-local data no
             * longer exists, remove the StatisticsData from our list
             * and fold the values into rootData.
             */
            rootData.add(data);
            iter.remove();
          }
        }
      }
      return visitor.aggregate();
    }

    /**
     * Get the total number of bytes read
     * @return the number of bytes
     */
    public long getBytesRead() {
      return visitAll(new StatisticsAggregator<Long>() {
        private long bytesRead = 0;

        @Override
        public void accept(StatisticsData data) {
          bytesRead += data.bytesRead;
        }

        public Long aggregate() {
          return bytesRead;
        }
      });
    }
    
    /**
     * Get the total number of bytes written
     * @return the number of bytes
     */
    public long getBytesWritten() {
      return visitAll(new StatisticsAggregator<Long>() {
        private long bytesWritten = 0;

        @Override
        public void accept(StatisticsData data) {
          bytesWritten += data.bytesWritten;
        }

        public Long aggregate() {
          return bytesWritten;
        }
      });
    }
    
    /**
     * Get the number of file system read operations such as list files
     * @return number of read operations
     */
    public int getReadOps() {
      return visitAll(new StatisticsAggregator<Integer>() {
        private int readOps = 0;

        @Override
        public void accept(StatisticsData data) {
          readOps += data.readOps;
          readOps += data.largeReadOps;
        }

        public Integer aggregate() {
          return readOps;
        }
      });
    }

    /**
     * Get the number of large file system read operations such as list files
     * under a large directory
     * @return number of large read operations
     */
    public int getLargeReadOps() {
      return visitAll(new StatisticsAggregator<Integer>() {
        private int largeReadOps = 0;

        @Override
        public void accept(StatisticsData data) {
          largeReadOps += data.largeReadOps;
        }

        public Integer aggregate() {
          return largeReadOps;
        }
      });
    }

    /**
     * Get the number of file system write operations such as create, append 
     * rename etc.
     * @return number of write operations
     */
    public int getWriteOps() {
      return visitAll(new StatisticsAggregator<Integer>() {
        private int writeOps = 0;

        @Override
        public void accept(StatisticsData data) {
          writeOps += data.writeOps;
        }

        public Integer aggregate() {
          return writeOps;
        }
      });
    }


    @Override
    public String toString() {
      return visitAll(new StatisticsAggregator<String>() {
        private StatisticsData total = new StatisticsData(null);

        @Override
        public void accept(StatisticsData data) {
          total.add(data);
        }

        public String aggregate() {
          return total.toString();
        }
      });
    }

    /**
     * Resets all statistics to 0.
     *
     * In order to reset, we add up all the thread-local statistics data, and
     * set rootData to the negative of that.
     *
     * This may seem like a counterintuitive way to reset the statsitics.  Why
     * can't we just zero out all the thread-local data?  Well, thread-local
     * data can only be modified by the thread that owns it.  If we tried to
     * modify the thread-local data from this thread, our modification might get
     * interleaved with a read-modify-write operation done by the thread that
     * owns the data.  That would result in our update getting lost.
     *
     * The approach used here avoids this problem because it only ever reads
     * (not writes) the thread-local data.  Both reads and writes to rootData
     * are done under the lock, so we're free to modify rootData from any thread
     * that holds the lock.
     */
    public void reset() {
      visitAll(new StatisticsAggregator<Void>() {
        private StatisticsData total = new StatisticsData(null);

        @Override
        public void accept(StatisticsData data) {
          total.add(data);
        }

        public Void aggregate() {
          total.negate();
          rootData.add(total);
          return null;
        }
      });
    }
    
    /**
     * Get the uri scheme associated with this statistics object.
     * @return the schema associated with this set of statistics
     */
    public String getScheme() {
      return scheme;
    }
  }
  
}
