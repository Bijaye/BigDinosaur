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

import com.bigdinosaur.core.fs.Path;
import com.bigdinosaur.core.io.Writable;




// Modify the normal concept given by hadoop ,make concept more wider than HadoopImpl core part.

public class BdConfiguration implements Iterable<Map.Entry<String,String>>,
Writable {
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
  public void writeXml(OutputStream out) throws IOException {
    writeXml(new OutputStreamWriter(out, "UTF-8"));
  }

  /** 
   * Write out the non-default properties in this configuration to the given
   * {@link Writer}.
   * 
   * @param out the writer to write to.
   */
  public void writeXml(Writer out) throws IOException {
    Document doc = asXmlDocument();

    try {
      DOMSource source = new DOMSource(doc);
      StreamResult result = new StreamResult(out);
      TransformerFactory transFactory = TransformerFactory.newInstance();
      Transformer transformer = transFactory.newTransformer();

      // Important to not hold Configuration log while writing result, since
      // 'out' may be an HDFS stream which needs to lock this configuration
      // from another thread.
      transformer.transform(source, result);
    } catch (TransformerException te) {
      throw new IOException(te);
    }
  }
  private synchronized Document asXmlDocument() throws IOException {
    Document doc;
    try {
      doc =
        DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    } catch (ParserConfigurationException pe) {
      throw new IOException(pe);
    }
    Element conf = doc.createElement("configuration");
    doc.appendChild(conf);
    conf.appendChild(doc.createTextNode("\n"));
    for (Enumeration<Object> e = properties.keys(); e.hasMoreElements();) {
      String name = (String)e.nextElement();
      Object object = properties.get(name);
      String value = null;
      if (object instanceof String) {
        value = (String) object;
      }else {
        continue;
      }
      Element propNode = doc.createElement("property");
      conf.appendChild(propNode);

      Element nameNode = doc.createElement("name");
      nameNode.appendChild(doc.createTextNode(name));
      propNode.appendChild(nameNode);

      Element valueNode = doc.createElement("value");
      valueNode.appendChild(doc.createTextNode(value));
      propNode.appendChild(valueNode);

      if (updatingResource != null) {
        String[] sources = updatingResource.get(name);
        if(sources != null) {
          for(String s : sources) {
            Element sourceNode = doc.createElement("source");
            sourceNode.appendChild(doc.createTextNode(s));
            propNode.appendChild(sourceNode);
          }
        }
      }
      
      conf.appendChild(doc.createTextNode("\n"));
    }
    return doc;
  }

}
