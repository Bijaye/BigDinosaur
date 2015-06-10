package org.bigdinosaur.configuration.test;

import org.bigdinosaur.conf.Configuration;

public class BigDinosaurConfigurationTest
{
  public static void main(String[] args) throws Exception {
    new Configuration().writeXml(System.out);
  }
}
