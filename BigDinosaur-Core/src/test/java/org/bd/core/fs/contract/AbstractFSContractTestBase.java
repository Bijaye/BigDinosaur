package org.bd.core.fs.contract;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.internal.AssumptionViolatedException;
import org.junit.rules.Timeout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bigdinosaur.config.BdConfiguration;
import com.bigdinosaur.core.fs.FileSystem;
import com.bigdinosaur.core.fs.Path;

import java.io.IOException;
import java.net.URI;


/**
 * This is the base class for all the contract tests
 */
public abstract class AbstractFSContractTestBase extends Assert
  implements ContractOptions {

  private static final Logger LOG =
    LoggerFactory.getLogger(AbstractFSContractTestBase.class);

  /**
   * Length of files to work with: {@value}
   */
  public static final int TEST_FILE_LEN = 1024;

  /**
   * standard test timeout: {@value}
   */
  public static final int DEFAULT_TEST_TIMEOUT = 180 * 1000;

  /**
   * The FS contract used for these tets
   */
  private AbstractFSContract contract;

  /**
   * The test filesystem extracted from it
   */
  private FileSystem fileSystem;

  /**
   * The path for tests
   */
  private Path testPath;

  /**
   * This must be implemented by all instantiated test cases
   * -provide the FS contract
   * @return the FS contract
   */
  protected abstract AbstractFSContract createContract(BdConfiguration conf);

  /**
   * Get the contract
   * @return the contract, which will be non-null once the setup operation has
   * succeeded
   */
  protected AbstractFSContract getContract() {
    return contract;
  }

  /**
   * Get the filesystem created in startup
   * @return the filesystem to use for tests
   */
  public FileSystem getFileSystem() {
    return fileSystem;
  }

  /**
   * Get the log of the base class
   * @return a logger
   */
  public static Logger getLog() {
    return LOG;
  }

  /**
   * Skip a test if a feature is unsupported in this FS
   * @param feature feature to look for
   * @throws IOException IO problem
   */
  protected void skipIfUnsupported(String feature) throws IOException {
    if (!isSupported(feature)) {
    }
  }

  /**
   * Is a feature supported?
   * @param feature feature
   * @return true iff the feature is supported
   * @throws IOException IO problems
   */
  protected boolean isSupported(String feature) throws IOException {
    return false;
//    return contract.isSupported(feature, false);
  }

  /**
   * Include at the start of tests to skip them if the FS is not enabled.
   */
  protected void assumeEnabled() {
    if (!contract.isEnabled())
      throw new AssumptionViolatedException("test cases disabled for " + contract);
  }

  /**
   * Create a configuration. May be overridden by tests/instantiations
   * @return a configuration
   */
  protected BdConfiguration createConfiguration() {
    return new BdConfiguration();
  }

  /**
   * Set the timeout for every test
   */
  @Rule
  public Timeout testTimeout = new Timeout(getTestTimeoutMillis());

  /**
   * Option for tests to override the default timeout value
   * @return the current test timeout
   */
  protected int getTestTimeoutMillis() {
    return DEFAULT_TEST_TIMEOUT;
  }


  /**
   * Setup: create the contract then init it
   * @throws Exception on any failure
   */
  @Before
  public void setup() throws Exception {
    contract = createContract(createConfiguration());
    contract.init();
    //skip tests if they aren't enabled
    assumeEnabled();
    //extract the test FS
    fileSystem = contract.getTestFileSystem();
    assertNotNull("null filesystem", fileSystem);
    URI fsURI = fileSystem.getUri();
    LOG.info("Test filesystem = {} implemented by {}",
        fsURI, fileSystem);
    //sanity check to make sure that the test FS picked up really matches
    //the scheme chosen. This is to avoid defaulting back to the localFS
    //which would be drastic for root FS tests
    assertEquals("wrong filesystem of " + fsURI,
                 contract.getScheme(), fsURI.getScheme());
    //create the test path
    testPath = getContract().getTestPath();
    mkdirs(testPath);
  }
  protected void mkdirs(Path path) throws IOException {
    assertTrue("Failed to mkdir " + path, fileSystem.mkdirs(path));
  }

  /**
   * Teardown
   * @throws Exception on any failure
   */
  @After
  public void teardown() throws Exception {
    deleteTestDirInTeardown();
  }

  /**
   * Delete the test dir in the per-test teardown
   * @throws IOException
   */
  protected void deleteTestDirInTeardown() throws IOException {
  }

  /**
   * Create a path under the test path provided by
   * the FS contract
   * @param filepath path string in
   * @return a path qualified by the test filesystem
   * @throws IOException IO problems
   */
  protected Path path(String filepath) throws IOException {
    return getFileSystem().makeQualified(
      new Path(getContract().getTestPath(), filepath));
  }

  /**
   * Take a simple path like "/something" and turn it into
   * a qualified path against the test FS
   * @param filepath path string in
   * @return a path qualified by the test filesystem
   * @throws IOException IO problems
   */
  protected Path absolutepath(String filepath) throws IOException {
    return getFileSystem().makeQualified(new Path(filepath));
  }

  /**
   * List a path in the test FS
   * @param path path to list
   * @return the contents of the path/dir
   * @throws IOException IO problems
   */
  protected String ls(Path path) throws IOException {
    return null;
//    return ContractTestUtils.ls(fileSystem, path);
  }

  /**
   * Describe a test. This is a replacement for javadocs
   * where the tests role is printed in the log output
   * @param text description
   */
  protected void describe(String text) {
    LOG.info(text);
  }

  

 
  


 
 

  /**
   * Assert that the result value == -1; which implies
   * that a read was successful
   * @param text text to include in a message (usually the operation)
   * @param result read result to validate
   */
  protected void assertMinusOne(String text, int result) {
    assertEquals(text + " wrong read result " + result, -1, result);
  }




}
