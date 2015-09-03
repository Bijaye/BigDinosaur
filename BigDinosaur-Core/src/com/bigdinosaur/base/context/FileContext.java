package com.bigdinosaur.base.context;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bigdinosaur.core.fs.FileStatus;
import com.bigdinosaur.core.fs.Path;

/**
 * The FileContext class provides an interface for users of the Hadoop file system. It exposes a
 * number of file system operations, e.g. create, open, list.
 * 
 * <h2>Path Names</h2>
 * 
 * The Hadoop file system supports a URI namespace and URI names. This enables multiple types of
 * file systems to be referenced using fully-qualified URIs. Two common Hadoop file system
 * implementati ons are
 * <ul>
 * <li>the local file system: file:///path
 * <li>the HDFS file system: hdfs://nnAddress:nnPort/path
 * </ul>
 * 
 * The Hadoop file system also supports additional naming schemes besides URIs. Hadoop has the
 * concept of a <i>default file system</i>, which implies a default URI scheme and authority. This
 * enables <i>slash-relative names</i> relative to the default FS, which are more convenient for
 * users and application writers. The default FS is typically set by the user's environment, though
 * it can also be manually specified.
 * <p>
 * 
 * Hadoop also supports <i>working-directory-relative</i> names, which are paths relative to the
 * current working directory (similar to Unix). The working directory can be in a different file
 * system than the default FS.
 * <p>
 * Thus, Hadoop path names can be specified as one of the following:
 * <ul>
 * <li>a fully-qualified URI: scheme://authority/path (e.g. hdfs://nnAddress:nnPort/foo/bar)
 * <li>a slash-relative name: path relative to the default file system (e.g. /foo/bar)
 * <li>a working-directory-relative name: path relative to the working dir (e.g. foo/bar)
 * </ul>
 * Relative paths with scheme (scheme:foo/bar) are illegal.
 * 
 * <h2>Role of FileContext and Configuration Defaults</h2>
 *
 * The FileContext is the analogue of per-process file-related state in Unix. It contains two
 * properties:
 * 
 * <ul>
 * <li>the default file system (for resolving slash-relative names)
 * <li>the umask (for file permissions)
 * </ul>
 * In general, these properties are obtained from the default configuration file in the user's
 * environment (see {@link BdConfiguration}).
 * 
 * Further file system properties are specified on the server-side. File system operations default
 * to using these server-side defaults unless otherwise specified.
 * <p>
 * The file system related server-side defaults are:
 * <ul>
 * <li>the home directory (default is "/user/userName")
 * <li>the initial wd (only for local fs)
 * <li>replication factor
 * <li>block size
 * <li>buffer size
 * <li>encryptDataTransfer
 * <li>checksum option. (checksumType and bytesPerChecksum)
 * </ul>
 *
 * <h2>Example Usage</h2>
 *
 * Example 1: use the default config read from the $HADOOP_CONFIG/core.xml. Unspecified values come
 * from core-defaults.xml in the release jar.
 * <ul>
 * <li>myFContext = FileContext.getFileContext(); // uses the default config // which has your
 * default FS
 * <li>myFContext.create(path, ...);
 * <li>myFContext.setWorkingDir(path);
 * <li>myFContext.open (path, ...);
 * <li>...
 * </ul>
 * Example 2: Get a FileContext with a specific URI as the default FS
 * <ul>
 * <li>myFContext = FileContext.getFileContext(URI);
 * <li>myFContext.create(path, ...);
 * <li>...
 * </ul>
 * Example 3: FileContext with local file system as the default
 * <ul>
 * <li>myFContext = FileContext.getLocalFSFileContext();
 * <li>myFContext.create(path, ...);
 * <li>...
 * </ul>
 * Example 4: Use a specific config, ignoring $HADOOP_CONFIG Generally you should not need use a
 * config unless you are doing
 * <ul>
 * <li>configX = someConfigSomeOnePassedToYou;
 * <li>myFContext = getFileContext(configX); // configX is not changed, // is passed down
 * <li>myFContext.create(path, ...);
 * <li>...
 * </ul>
 * 
 */

public class FileContext
{

  public static final Log LOG = LogFactory.getLog(FileContext.class);
 public  FileStatus getFileStatus(Path path){
    return new FileStatus();
  }

}
