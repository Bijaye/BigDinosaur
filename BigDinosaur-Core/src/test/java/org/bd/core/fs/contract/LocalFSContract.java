package org.bd.core.fs.contract;



import java.io.IOException;

import com.bigdinosaur.config.BdConfiguration;
import com.bigdinosaur.core.fs.FileSystem;
import com.bigdinosaur.core.fs.Path;

/**
 * The contract of the Local filesystem.
 * This changes its feature set from platform for platform -the default
 * set is updated during initialization.
 *
 * This contract contains some override points, to permit
 * the raw local filesystem and other filesystems to subclass it.
 */
public class LocalFSContract extends AbstractFSContract {

  public static final String CONTRACT_XML = "contract/localfs.xml";
  public static final String SYSPROP_TEST_BUILD_DATA = "test.build.data";
  public static final String DEFAULT_TEST_BUILD_DATA_DIR = "test/build/data";
  private FileSystem fs;

  public LocalFSContract(BdConfiguration conf) {
    super(conf);
    //insert the base features
    addConfResource(getContractXml());
  }

  /**
   * Return the contract file for this filesystem
   * @return the XML
   */
  protected String getContractXml() {
    return CONTRACT_XML;
  }

  @Override
  public void init() throws IOException {
    super.init();
    try
    {
      fs = getLocalFS();
    }
    catch (Exception e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  

  /**
   * Get the local filesystem. This may be overridden
   * @return the filesystem
   * @throws Exception 
   */
  protected FileSystem getLocalFS() throws Exception {
    return FileSystem.getLocal(getConf());
  }

  @Override
  public FileSystem getTestFileSystem() throws IOException {
    return fs;
  }

  @Override
  public String getScheme() {
    return "file";
  }

  @Override
  public Path getTestPath() {
    Path path = fs.makeQualified(new Path(  getTestDataDir()));
    
    return path;
  }

  /**
   * Get the test data directory
   * @return the directory for test data
   */
  protected String getTestDataDir() {
    return System.getProperty(SYSPROP_TEST_BUILD_DATA, DEFAULT_TEST_BUILD_DATA_DIR);
  }
}
