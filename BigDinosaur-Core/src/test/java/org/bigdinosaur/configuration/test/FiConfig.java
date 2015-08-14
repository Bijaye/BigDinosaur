package org.bigdinosaur.configuration.test;

import org.bigdinosaur.conf.Configuration;

import test.java.org.bigdinosaur.configuration.test.ProbabilityModel;




/**
 * This class wraps the logic around fault injection configuration file
 * Default file is expected to be found in src/test/fi-site.xml
 * This default file should be copied by JUnit Ant's tasks to 
 * build/test/extraconf folder before tests are ran
 * An alternative location can be set through
 *   -Dfi.config=<file_name>
 */
public class FiConfig {
  private static final String CONFIG_PARAMETER = ProbabilityModel.FPROB_NAME + "config";
  private static final String DEFAULT_CONFIG = "fi-site.xml";
  private static Configuration conf;
  static {
    if (conf == null) {
      conf = new Configuration(false);
      String configName = System.getProperty(CONFIG_PARAMETER, DEFAULT_CONFIG);
      conf.addResource(configName);
    }
  }
  
  /**
   * Method provides access to local Configuration 
   * 
   * @return Configuration initialized with fault injection's parameters
   */
  public static Configuration getConfig() {
    return conf;
  }
 
}
