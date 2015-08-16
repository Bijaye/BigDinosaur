package com.bd.core.net;


import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.bigdinosaur.config.Configuration;

public class TestScriptBasedMappingWithDependency extends TestCase {

  
  public TestScriptBasedMappingWithDependency() {

  }

  @Test
  public void testNoArgsMeansNoResult() {
    Configuration conf = new Configuration();
    conf.setInt(ScriptBasedMapping.SCRIPT_ARG_COUNT_KEY,
                ScriptBasedMapping.MIN_ALLOWABLE_ARGS - 1);
    conf.set(ScriptBasedMapping.SCRIPT_FILENAME_KEY, "any-filename-1");
    conf.set(ScriptBasedMappingWithDependency.DEPENDENCY_SCRIPT_FILENAME_KEY, 
        "any-filename-2");
    conf.setInt(ScriptBasedMapping.SCRIPT_ARG_COUNT_KEY, 10);

    ScriptBasedMappingWithDependency mapping = createMapping(conf);
    List<String> names = new ArrayList<String>();
    names.add("some.machine.name");
    names.add("other.machine.name");
    List<String> result = mapping.resolve(names);
    assertNull("Expected an empty list for resolve", result);
    result = mapping.getDependency("some.machine.name");
    assertNull("Expected an empty list for getDependency", result);
  }

  @Test
  public void testNoFilenameMeansSingleSwitch() throws Throwable {
    Configuration conf = new Configuration();
    ScriptBasedMapping mapping = createMapping(conf);
    assertTrue("Expected to be single switch", mapping.isSingleSwitch());
    assertTrue("Expected to be single switch",
               AbstractDNSToSwitchMapping.isMappingSingleSwitch(mapping));
  }

  @Test
  public void testFilenameMeansMultiSwitch() throws Throwable {
    Configuration conf = new Configuration();
    conf.set(ScriptBasedMapping.SCRIPT_FILENAME_KEY, "any-filename");
    ScriptBasedMapping mapping = createMapping(conf);
    assertFalse("Expected to be multi switch", mapping.isSingleSwitch());
    mapping.setConf(new Configuration());
    assertTrue("Expected to be single switch", mapping.isSingleSwitch());
  }

  @Test
  public void testNullConfig() throws Throwable {
    ScriptBasedMapping mapping = createMapping(null);
    assertTrue("Expected to be single switch", mapping.isSingleSwitch());
  }

  private ScriptBasedMappingWithDependency createMapping(Configuration conf) {
    ScriptBasedMappingWithDependency mapping = 
        new ScriptBasedMappingWithDependency();
    mapping.setConf(conf);
    return mapping;
  }
}
