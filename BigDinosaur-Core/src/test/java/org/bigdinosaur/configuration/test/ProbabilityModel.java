package org.bigdinosaur.configuration.test;

import java.util.Random;

import org.bigdinosaur.conf.Configuration;

import test.java.org.bigdinosaur.configuration.test.FiConfig;


public class ProbabilityModel {
  private static Random generator = new Random();

  static final String FPROB_NAME = "fi.";
  private static final String ALL_PROBABILITIES = FPROB_NAME + "*";
  private static final float DEFAULT_PROB = 0.00f; //Default probability is 0%
  private static final float MAX_PROB = 1.00f; // Max probability is 100%

  private static Configuration conf = FiConfig.getConfig();

  static {
    // Set new default probability if specified through a system.property
    // If neither is specified set default probability to DEFAULT_PROB 
    conf.set(ALL_PROBABILITIES, 
        System.getProperty(ALL_PROBABILITIES, 
            conf.get(ALL_PROBABILITIES, Float.toString(DEFAULT_PROB))));

  }

  /**
   * Simplistic method to check if we have reached the point of injection
   * @param klassName is the name of the probability level to check. 
   *  If a configuration has been set for "fi.myClass" then you can check if the
   *  inject criteria has been reached by calling this method with "myClass"
   *  string as its parameter
   * @return true if the probability threshold has been reached; false otherwise
   */
  public static boolean injectCriteria(String klassName) {
    boolean trigger = false;
    if (generator.nextFloat() < getProbability(klassName)) {
      trigger = true;
    }
    return trigger;
  }

  /**
   * This primitive checks for arbitrary set of desired probability. If the 
   * level hasn't been set method will return default setting.
   * The probability expected to be set as an float between 0.0 and 1.0
   * @param klass is the name of the resource
   * @return float representation of configured probability level of 
   *  the requested resource or default value if hasn't been set
   */
  protected static float getProbability(final String klass) {
    String newProbName = FPROB_NAME + klass;

    String newValue = System.getProperty(newProbName, conf.get(ALL_PROBABILITIES));
    if (newValue != null && !newValue.equals(conf.get(newProbName)))
      conf.set(newProbName, newValue);

    float ret = conf.getFloat(newProbName,
        conf.getFloat(ALL_PROBABILITIES, DEFAULT_PROB));
    // Make sure that probability level is valid.
    if (ret < DEFAULT_PROB || ret > MAX_PROB) {
      ret = conf.getFloat(ALL_PROBABILITIES, DEFAULT_PROB);
    }
    
    return ret;
  }
}
