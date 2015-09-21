package com.bigdinosaur.config;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.base.bigdinosaur.master.TransformData;
import com.bigdinosaur.core.fs.Path;
import com.bigdinosaur.core.io.Writable;




// Modify the normal concept given by hadoop ,make concept more wider than HadoopImpl core part.

public class BdConfiguration implements Iterable<Map.Entry<String,String>>,
Writable {
  // 
  TransformData dataconfiguration; 
  
  private HashMap<String, String> updatingResource;
  private static final CopyOnWriteArrayList<String> defaultResources =
      new CopyOnWriteArrayList<String>();
  private boolean loadDefaults = true;
  private ArrayList<Resource> resources = new ArrayList<Resource>();
  
 public  BdConfiguration(){
    
  }
 public  BdConfiguration(boolean loadDefaults){
    this.loadDefaults=loadDefaults;
  }
 public  BdConfiguration(TransformData transform){
   this.dataconfiguration=dataconfiguration;
   
 }
  public void set(String key, String value)
  {
    updatingResource.put(key, value);
  }

  public String get(String name)
  {
    String value = updatingResource.get(name);

    return value;
  }
  
  /**
   * Add a default resource. Resources are loaded in the order of the resources 
   * added.
   * @param name file name. File should be present in the classpath.
   */
  public static synchronized void addDefaultResource(String name) {
    if(!defaultResources.contains(name)) {
      defaultResources.add(name);
     
    }
  }
  public synchronized void reloadConfiguration() {
  }
  
  private synchronized void addResourceObject(Resource resource) {
    resources.add(resource);                      // add to resources
    reloadConfiguration();
  }
  public void addResource(URL url) {
    addResourceObject(new Resource(url));
  }
  public void addResource(Path file) {
    addResourceObject(new Resource(file));
  }


  private static class Resource
  {
    private final Object resource;

    private final String name;

    public Resource(Object resource)
    {
      this(resource, resource.toString());
    }

    public Resource(Object resource, String name)
    {
      this.resource = resource;
      this.name = name;
    }

    public String getName()
    {
      return name;
    }

    public Object getResource()
    {
      return resource;
    }

    @Override
    public String toString()
    {
      return name;
    }
  }


  @Override
  public void write(DataOutput out) throws IOException
  {
    // TODO Auto-generated method stub
    
  }
  @Override
  public void readFields(DataInput in) throws IOException
  {
    // TODO Auto-generated method stub
    
  }
  @Override
  public Iterator<Entry<String, String>> iterator()
  {
    // TODO Auto-generated method stub
    return null;
  }
  /** 
   * Get the value of the <code>name</code>. If the key is deprecated,
   * it returns the value of the first key which replaces the deprecated key
   * and is not null.
   * If no such property exists,
   * then <code>defaultValue</code> is returned.
   * 
   * @param name property name, will be trimmed before get value.
   * @param defaultValue default value.
   * @return property value, or <code>defaultValue</code> if the property 
   *         doesn't exist.                    
   */
  public String get(String name, String defaultValue) {
//    String[] names = handleDeprecation(deprecationContext.get(), name);
    String result = null;
//    for(String n : names) {
//      result = substituteVars(getProps().getProperty(n, defaultValue));
//    }
    return result;
  }
  public int getInt(String name, int defaultValue) {
    String valueString = getTrimmed(name);
    if (valueString == null)
      return defaultValue;
    String hexString = getHexDigits(valueString);
    if (hexString != null) {
      return Integer.parseInt(hexString, 16);
    }
    return Integer.parseInt(valueString);
  }
  
  private String getHexDigits(String value) {
    boolean negative = false;
    String str = value;
    String hexString = null;
    if (value.startsWith("-")) {
      negative = true;
      str = value.substring(1);
    }
    if (str.startsWith("0x") || str.startsWith("0X")) {
      hexString = str.substring(2);
      if (negative) {
        hexString = "-" + hexString;
      }
      return hexString;
    }
    return null;
  }
  

  public String getTrimmed(String name) {
    String value = get(name);
    
    if (null == value) {
      return null;
    } else {
      return value.trim();
    }
  }
  
  
  }
  

