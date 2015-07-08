package com.bigdinosaur.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

// Modify the normal concept given by hadoop ,make concept more wider than HadoopImpl core part.



/** 
 * Provides access to configuration parameters.
 *
 * 
 *
 * Configurations are specified by resources. A resource contains a set of
 * name/value pairs as XML data. Each resource is named by either a 
 * String or by a link Path. If named by a String, 
 * then the classpath is examined for a file with that name.  If named by a 
 * Path, then the local filesystem is examined directly, without 
 * referring to the classpath.
 *
 * Unless explicitly turned off, big dinosaur by default specifies two 
 * resources, loaded in-order from the classpath 
 * core-default.xml
 *  Read-only defaults for big dinosaur
 * core-site.xml Site-specific configuration for a given big dinosaur
 * installation.
 * 
 * Applications may add additional resources, which are loaded
 * subsequent to these resources in the order they are added.
 * 
 *
 */
public class Configuration implements Iterable<Map.Entry<String,String>>
                                       {

  
  private ArrayList<Object> resources = new ArrayList<Object>();
  private Set<String> finalParameters = new HashSet<String>();
  
  private boolean loadDefaults = true;
  
  private static final WeakHashMap<Configuration,Object> REGISTRY = 
    new WeakHashMap<Configuration,Object>();
  
  private static final ArrayList<String> defaultResources = 
    new ArrayList<String>();
  
  static{
    ClassLoader cL = Thread.currentThread().getContextClassLoader();
    if (cL == null) {
      cL = Configuration.class.getClassLoader();
    }
    if(cL.getResource("big dinosaur-site.xml")!=null) {
   
  }
  
 

 
  }

  @Override
  public Iterator<Entry<String, String>> iterator()
  {
    return null;
  }
  
 

}
