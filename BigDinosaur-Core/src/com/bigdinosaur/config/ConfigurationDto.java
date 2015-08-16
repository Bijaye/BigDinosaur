package com.bigdinosaur.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigurationDto
{
  //host1=r1,host2=r1,host3=r2
  //one rack can have multiple host 
  String hostname;
  String rackname;// it is rack id 
  /* Only one instance per JVM */
  //list of all rackid and host name is added in map 
  private static final Map<String, String> nameToRackMap = new HashMap<String, String>();
  List<String> rackidlist = new ArrayList<String>();

  

}
