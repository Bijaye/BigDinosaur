package org.bd.core.fs;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bigdinosaur.config.BdConfiguration;
import com.bigdinosaur.core.fs.Path;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.common.util.concurrent.Uninterruptibles;

 
public class BdConfigurationTest {
  private BdConfiguration conf;
  final static String CONFIG = new File("./test-config-TestBdConfigurationDeprecation.xml").getAbsolutePath();
  final static String CONFIG2 = new File("./test-config2-TestBdConfigurationDeprecation.xml").getAbsolutePath();
  final static String CONFIG3 = new File("./test-config3-TestBdConfigurationDeprecation.xml").getAbsolutePath();
  BufferedWriter out;
  
  static {
    BdConfiguration.addDefaultResource("test-fake-default.xml");
  }

  @Before
  public void setUp() throws Exception {
    conf = new BdConfiguration(false);
  }

  @After
  public void tearDown() throws Exception {
    new File(CONFIG).delete();
    new File(CONFIG2).delete();
    new File(CONFIG3).delete();
  }
  
  private void startConfig() throws IOException{
    out.write("<?xml version=\"1.0\"?>\n");
    out.write("<configuration>\n");
  }

  private void endConfig() throws IOException{
    out.write("</configuration>\n");
    out.close();
  }

  void appendProperty(String name, String val) throws IOException {
    appendProperty(name, val, false);
  }
 
  void appendProperty(String name, String val, boolean isFinal)
    throws IOException {
    out.write("<property>");
    out.write("<name>");
    out.write(name);
    out.write("</name>");
    out.write("<value>");
    out.write(val);
    out.write("</value>");
    if (isFinal) {
      out.write("<final>true</final>");
    }
    out.write("</property>\n");
  }
  
  private void addDeprecationToBdConfiguration() {
  }
  
  /**
   * This test checks the correctness of loading/setting the properties in terms
   * of occurrence of deprecated keys.
   * @throws IOException 
   */
  @Test
  public void testDeprecation() throws IOException {
    addDeprecationToBdConfiguration();
    out=new BufferedWriter(new FileWriter(CONFIG));
    startConfig();
    // load an old key and a new key.
    appendProperty("A", "a");
    appendProperty("D", "d");
    // load an old key with multiple new-key mappings
    appendProperty("P", "p");
    endConfig();
    Path fileResource = new Path(CONFIG);
    conf.addResource(fileResource);
    
    // check if loading of old key with multiple new-key mappings actually loads
    // the corresponding new keys. 
    assertEquals("p", conf.get("P"));
    assertEquals("p", conf.get("Q"));
    assertEquals("p", conf.get("R"));
    
    assertEquals("a", conf.get("A"));
    assertEquals("a", conf.get("B"));
    assertEquals("d", conf.get("C"));
    assertEquals("d", conf.get("D"));
    
    out=new BufferedWriter(new FileWriter(CONFIG2));
    startConfig();
    // load the old/new keys corresponding to the keys loaded before.
    appendProperty("B", "b");
    appendProperty("C", "c");
    endConfig();
    Path fileResource1 = new Path(CONFIG2);
    conf.addResource(fileResource1);
    
    assertEquals("b", conf.get("A"));
    assertEquals("b", conf.get("B"));
    assertEquals("c", conf.get("C"));
    assertEquals("c", conf.get("D"));
    
    // set new key
    conf.set("N","n");
    // get old key
    assertEquals("n", conf.get("M"));
    // check consistency in get of old and new keys
    assertEquals(conf.get("M"), conf.get("N"));
    
    // set old key and then get new key(s).
    conf.set("M", "m");
    assertEquals("m", conf.get("N"));
    conf.set("X", "x");
    assertEquals("x", conf.get("X"));
    assertEquals("x", conf.get("Y"));
    assertEquals("x", conf.get("Z"));
    
    // set new keys to different values
    conf.set("Y", "y");
    conf.set("Z", "z");
    // get old key
    assertEquals("z", conf.get("X"));
  }

  /**
   * This test is to ensure the correctness of loading of keys with respect to
   * being marked as final and that are related to deprecation.
   * @throws IOException
   */
  @Test
  public void testDeprecationForFinalParameters() throws IOException {
    addDeprecationToBdConfiguration();
    out=new BufferedWriter(new FileWriter(CONFIG));
    startConfig();
    // set the following keys:
    // 1.old key and final
    // 2.new key whose corresponding old key is final
    // 3.old key whose corresponding new key is final
    // 4.new key and final
    // 5.new key which is final and has null value.
    appendProperty("A", "a", true);
    appendProperty("D", "d");
    appendProperty("E", "e");
    appendProperty("H", "h", true);
    appendProperty("J", "", true);
    endConfig();
    Path fileResource = new Path(CONFIG);
    conf.addResource(fileResource);
    
    assertEquals("a", conf.get("A"));
    assertEquals("a", conf.get("B"));
    assertEquals("d", conf.get("C"));
    assertEquals("d", conf.get("D"));
    assertEquals("e", conf.get("E"));
    assertEquals("e", conf.get("F"));
    assertEquals("h", conf.get("G"));
    assertEquals("h", conf.get("H"));
    assertNull(conf.get("I"));
    assertNull(conf.get("J"));
    
    out=new BufferedWriter(new FileWriter(CONFIG2));
    startConfig();
    // add the corresponding old/new keys of those added to CONFIG1
    appendProperty("B", "b");
    appendProperty("C", "c", true);
    appendProperty("F", "f", true);
    appendProperty("G", "g");
    appendProperty("I", "i");
    endConfig();
    Path fileResource1 = new Path(CONFIG2);
    conf.addResource(fileResource1);
    
    assertEquals("a", conf.get("A"));
    assertEquals("a", conf.get("B"));
    assertEquals("c", conf.get("C"));
    assertEquals("c", conf.get("D"));
    assertEquals("f", conf.get("E"));
    assertEquals("f", conf.get("F"));
    assertEquals("h", conf.get("G"));
    assertEquals("h", conf.get("H"));
    assertNull(conf.get("I"));
    assertNull(conf.get("J"));
    
    out=new BufferedWriter(new FileWriter(CONFIG3));
    startConfig();
    // change the values of all the previously loaded 
    // keys (both deprecated and new)
    appendProperty("A", "a1");
    appendProperty("B", "b1");
    appendProperty("C", "c1");
    appendProperty("D", "d1");
    appendProperty("E", "e1");
    appendProperty("F", "f1");
    appendProperty("G", "g1");
    appendProperty("H", "h1");
    appendProperty("I", "i1");
    appendProperty("J", "j1");
    endConfig();
    fileResource = new Path(CONFIG);
    conf.addResource(fileResource);
    
    assertEquals("a", conf.get("A"));
    assertEquals("a", conf.get("B"));
    assertEquals("c", conf.get("C"));
    assertEquals("c", conf.get("D"));
    assertEquals("f", conf.get("E"));
    assertEquals("f", conf.get("F"));
    assertEquals("h", conf.get("G"));
    assertEquals("h", conf.get("H"));
    assertNull(conf.get("I"));
    assertNull(conf.get("J"));
  }

  @Test
  public void testSetBeforeAndGetAfterDeprecation() {
    BdConfiguration conf = new BdConfiguration();
    conf.set("oldkey", "hello");
    assertEquals("hello", conf.get("newkey"));
  }
  
  @Test
  public void testSetBeforeAndGetAfterDeprecationAndDefaults() {
    BdConfiguration conf = new BdConfiguration();
    conf.set("tests.fake-default.old-key", "hello");
    assertEquals("hello", conf.get("tests.fake-default.new-key"));
  }

  @Test
  public void testIteratorWithDeprecatedKeys() {
    BdConfiguration conf = new BdConfiguration();
    conf.set("k", "v");
    conf.set("dK", "V");
    assertEquals("V", conf.get("dK"));
    assertEquals("V", conf.get("nK"));
    conf.set("nK", "VV");
    assertEquals("VV", conf.get("dK"));
    assertEquals("VV", conf.get("nK"));
    boolean kFound = false;
    boolean dKFound = false;
    boolean nKFound = false;
    for (Map.Entry<String, String> entry : conf) {
      if (entry.getKey().equals("k")) {
        assertEquals("v", entry.getValue());
        kFound = true;
      }
      if (entry.getKey().equals("dK")) {
        assertEquals("VV", entry.getValue());
        dKFound = true;
      }
      if (entry.getKey().equals("nK")) {
        assertEquals("VV", entry.getValue());
        nKFound = true;
      }
    }
    assertTrue("regular Key not found", kFound);
    assertTrue("deprecated Key not found", dKFound);
    assertTrue("new Key not found", nKFound);
  }
  
  @Test
  public void testUnsetWithDeprecatedKeys() {
    BdConfiguration conf = new BdConfiguration();
    conf.set("nK", "VV");
    assertEquals("VV", conf.get("dK"));
    assertEquals("VV", conf.get("nK"));
    assertNull(conf.get("dK"));
    assertNull(conf.get("nK"));
    conf.set("nK", "VV");
    assertEquals("VV", conf.get("dK"));
    assertEquals("VV", conf.get("nK"));
    assertNull(conf.get("dK"));
    assertNull(conf.get("nK"));
  }

  private static String getTestKeyName(int threadIndex, int testIndex) {
    return "testConcurrentDeprecateAndManipulate.testKey." +
                  threadIndex + "." + testIndex;
  }
  
  /**
   * Run a set of threads making changes to the deprecations
   * concurrently with another set of threads calling get()
   * and set() on BdConfiguration objects.
   */
  @SuppressWarnings("deprecation")
  @Test(timeout=60000)
  public void testConcurrentDeprecateAndManipulate() throws Exception {
    final int NUM_THREAD_IDS = 10;
    final int NUM_KEYS_PER_THREAD = 1000;
    ScheduledThreadPoolExecutor executor =
      new ScheduledThreadPoolExecutor(2 * NUM_THREAD_IDS,
      new ThreadFactoryBuilder().setDaemon(true).
      setNameFormat("testConcurrentDeprecateAndManipulate modification thread %d").
      build());
    final CountDownLatch latch = new CountDownLatch(1);
    final AtomicInteger highestModificationThreadId = new AtomicInteger(1);
    List<Future<Void>> futures = new LinkedList<Future<Void>>();
    for (int i = 0; i < NUM_THREAD_IDS; i++) {
      futures.add(executor.schedule(new Callable<Void>() {
        @Override
        public Void call() throws Exception {
          latch.await();
          int threadIndex = highestModificationThreadId.addAndGet(1);
          for (int i = 0; i < NUM_KEYS_PER_THREAD; i++) {
            String testKey = getTestKeyName(threadIndex, i);
            String testNewKey = testKey + ".new";
          }
          return null;
        }
      }, 0, TimeUnit.SECONDS));
    }
    final AtomicInteger highestAccessThreadId = new AtomicInteger(1);
    for (int i = 0; i < NUM_THREAD_IDS; i++) {
      futures.add(executor.schedule(new Callable<Void>() {
        @Override
        public Void call() throws Exception {
          BdConfiguration conf = new BdConfiguration();
          latch.await();
          int threadIndex = highestAccessThreadId.addAndGet(1);
          for (int i = 0; i < NUM_KEYS_PER_THREAD; i++) {
            String testNewKey = getTestKeyName(threadIndex, i) + ".new";
            String value = "value." + threadIndex + "." + i;
            conf.set(testNewKey, value);
            Assert.assertEquals(value, conf.get(testNewKey));
          }
          return null;
        }
      }, 0, TimeUnit.SECONDS));
    }
    latch.countDown(); // allow all threads to proceed
    for (Future<Void> future : futures) {
      Uninterruptibles.getUninterruptibly(future);
    }
  }

  @Test
  public void testNoFalseDeprecationWarning() throws IOException {
    BdConfiguration conf = new BdConfiguration();
    conf.set("BB", "bb");
    conf.get("BB");
    conf.writeXml(new ByteArrayOutputStream());
    conf.set("AA", "aa");
  }
  
  @Test
  public void testDeprecationSetUnset() throws IOException {
    addDeprecationToBdConfiguration();
    BdConfiguration conf = new BdConfiguration();
    //"X" is deprecated by "Y" and "Z"
    conf.set("Y", "y");
    assertEquals("y", conf.get("Z"));
    conf.set("X", "x");
    assertEquals("x", conf.get("Z"));
    assertEquals(null, conf.get("Z"));
    assertEquals(null, conf.get("X"));
  }
}
