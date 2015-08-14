package com.bigdinosaur.config;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

// Modify the normal concept given by hadoop ,make concept more wider than HadoopImpl core part.




public class Configuration implements Iterable<Map.Entry<String,String>>
                                       {

  
  private ArrayList<Object> resources = new ArrayList<Object>();
  private Set<String> finalParameters = new HashSet<String>();
  
  private boolean loadDefaults = true;
  private Properties properties;
  private Properties overlay;
  private ClassLoader classLoader;
  private boolean quietmode = true;
  private static final WeakHashMap<Configuration,Object> REGISTRY = 
      
    new WeakHashMap<Configuration,Object>();
  
  
  private static Pattern varPat = Pattern.compile("\\$\\{[^\\}\\$\u0020]+\\}");
  private static int MAX_SUBST = 20;
  
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
  public String get(String name) {
    return substituteVars(getProps().getProperty(name));
  }
  protected synchronized Properties getProps() {
    if (properties == null) {
      properties = new Properties();
      loadResources(properties, resources, quietmode);
      if (overlay!= null)
        properties.putAll(overlay);
    }
    return properties;
  }

 
  
  private String substituteVars(String expr) {
    if (expr == null) {
      return null;
    }
    Matcher match = varPat.matcher("");
    String eval = expr;
    for(int s=0; s<MAX_SUBST; s++) {
      match.reset(eval);
      if (!match.find()) {
        return eval;
      }
      String var = match.group();
      var = var.substring(2, var.length()-1); // remove ${ .. }
      String val = null;
      try {
        val = System.getProperty(var);
      } catch(SecurityException se) {
      }
      if (val == null) {
        val = getRaw(var);
      }
      if (val == null) {
        return eval; // return literal ${var}: var is unbound
      }
      // substitute
      eval = eval.substring(0, match.start())+val+eval.substring(match.end());
    }
    throw new IllegalStateException("Variable substitution depth too large: " 
                                    + MAX_SUBST + " " + expr);
  }
  public String getRaw(String name) {
    return getProps().getProperty(name);
  }

  public URL getResource(String name) {
    return classLoader.getResource(name);
  }
  
  
  
  private void loadResources(Properties properties,
                             ArrayList resources,
                             boolean quiet) {
    if(loadDefaults) {
      for (String resource : defaultResources) {
        loadResource(properties, resource, quiet);
      }
    
      //support the hadoop-site.xml as a deprecated case
      if(getResource("hadoop-site.xml")!=null) {
        loadResource(properties, "hadoop-site.xml", quiet);
      }
    }
    
    for (Object resource : resources) {
      loadResource(properties, resource, quiet);
    }
  }
  
  private void loadResource(Properties properties, Object name, boolean quiet) {
    try {
      DocumentBuilderFactory docBuilderFactory 
        = DocumentBuilderFactory.newInstance();
      //ignore all comments inside the xml file
      docBuilderFactory.setIgnoringComments(true);

      //allow includes in the xml file
      docBuilderFactory.setNamespaceAware(true);
      try {
          docBuilderFactory.setXIncludeAware(true);
      } catch (UnsupportedOperationException e) {
      
      }
      DocumentBuilder builder = docBuilderFactory.newDocumentBuilder();
      Document doc = null;
      Element root = null;

      if (name instanceof URL) {                  // an URL resource
        URL url = (URL)name;
        if (url != null) {
          if (!quiet) {
           
          }
          doc = builder.parse(url.toString());
        }
      } else if (name instanceof String) {        // a CLASSPATH resource
        URL url = getResource((String)name);
        if (url != null) {
          if (!quiet) {
          }
          doc = builder.parse(url.toString());
        }
      } else if (name instanceof Path) {          // a file resource
        // Can't use FileSystem API or we get an infinite loop
        // since FileSystem uses Configuration API.  Use java.io.File instead.
        File file = new File(((Path)name).toUri().getPath())
          .getAbsoluteFile();
        if (file.exists()) {
          if (!quiet) {
          }
          InputStream in = new BufferedInputStream(new FileInputStream(file));
          try {
            doc = builder.parse(in);
          } finally {
            in.close();
          }
        }
      } else if (name instanceof InputStream) {
        try {
          doc = builder.parse((InputStream)name);
        } finally {
          ((InputStream)name).close();
        }
      } else if (name instanceof Element) {
        root = (Element)name;
      }

      if (doc == null && root == null) {
        if (quiet)
          return;
        throw new RuntimeException(name + " not found");
      }

      if (root == null) {
        root = doc.getDocumentElement();
      }
      if (!"configuration".equals(root.getTagName())){
      }
      NodeList props = root.getChildNodes();
      for (int i = 0; i < props.getLength(); i++) {
        Node propNode = props.item(i);
        if (!(propNode instanceof Element))
          continue;
        Element prop = (Element)propNode;
        if ("configuration".equals(prop.getTagName())) {
          loadResource(properties, prop, quiet);
          continue;
        }
        if (!"property".equals(prop.getTagName())){
        }
        NodeList fields = prop.getChildNodes();
        String attr = null;
        String value = null;
        boolean finalParameter = false;
        for (int j = 0; j < fields.getLength(); j++) {
          Node fieldNode = fields.item(j);
          if (!(fieldNode instanceof Element))
            continue;
          Element field = (Element)fieldNode;
          if ("name".equals(field.getTagName()) && field.hasChildNodes())
            attr = ((Text)field.getFirstChild()).getData().trim();
          if ("value".equals(field.getTagName()) && field.hasChildNodes())
            value = ((Text)field.getFirstChild()).getData();
          if ("final".equals(field.getTagName()) && field.hasChildNodes())
            finalParameter = "true".equals(((Text)field.getFirstChild()).getData());
        }
        
        // Ignore this parameter if it has already been marked as 'final'
        if (attr != null && value != null) {
          if (!finalParameters.contains(attr)) {
            properties.setProperty(attr, value);
            if (finalParameter)
              finalParameters.add(attr);
          } else {
           
          }
        }
      }
  
  
  
    }
    catch( Exception x){
      
    }
    
  }
                                       }
