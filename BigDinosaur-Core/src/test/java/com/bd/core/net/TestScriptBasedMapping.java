package com.bd.core.net;



import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.bigdinosaur.config.BdConfiguration;

public class TestScriptBasedMapping extends TestCase {


  
  public TestScriptBasedMapping() {

  }

  @Test
  public void testNoArgsMeansNoResult() {
    BdConfiguration conf = new BdConfiguration();
    conf.setInt(ScriptBasedMapping.SCRIPT_ARG_COUNT_KEY,
                ScriptBasedMapping.MIN_ALLOWABLE_ARGS - 1);
    conf.set(ScriptBasedMapping.SCRIPT_FILENAME_KEY, "any-filename");
    conf.set(ScriptBasedMapping.SCRIPT_FILENAME_KEY, "any-filename");
    ScriptBasedMapping mapping = createMapping(conf);
    List<String> names = new ArrayList<String>();
    names.add("some.machine.name");
    names.add("other.machine.name");
    List<String> result = mapping.resolve(names);
    assertNull("Expected an empty list", result);
  }

  @Test
  public void testNoFilenameMeansSingleSwitch() throws Throwable {
    BdConfiguration conf = new BdConfiguration();
    ScriptBasedMapping mapping = createMapping(conf);
    assertTrue("Expected to be single switch", mapping.isSingleSwitch());
    assertTrue("Expected to be single switch",
               AbstractDNSToSwitchMapping.isMappingSingleSwitch(mapping));
  }

  @Test
  public void testFilenameMeansMultiSwitch() throws Throwable {
    BdConfiguration conf = new BdConfiguration();
    conf.set(ScriptBasedMapping.SCRIPT_FILENAME_KEY, "any-filename");
    ScriptBasedMapping mapping = createMapping(conf);
    assertFalse("Expected to be multi switch", mapping.isSingleSwitch());
    mapping.setConf(new BdConfiguration());
    assertTrue("Expected to be single switch", mapping.isSingleSwitch());
  }

  @Test
  public void testNullConfig() throws Throwable {
    ScriptBasedMapping mapping = createMapping(null);
    assertTrue("Expected to be single switch", mapping.isSingleSwitch());

  }
  private ScriptBasedMapping createMapping(BdConfiguration conf) {
    ScriptBasedMapping mapping = new ScriptBasedMapping();
    mapping.setConf(conf);
    return mapping;
  }
}
