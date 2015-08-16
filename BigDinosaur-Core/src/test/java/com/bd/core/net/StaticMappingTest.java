package com.bd.core.net;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.bigdinosaur.config.Configuration;
import com.bigdinosaur.core.net.NetworkTopology;

public class StaticMappingTest  {

  /**
   * Key to define the node mapping as a comma-delimited list of host=rack
   * mappings, e.g. <code>host1=r1,host2=r1,host3=r2</code>.
   * <p/>
   * Value: {@value}
   * <p/>
   * <b>Important: </b>spaces not trimmed and are considered significant.
   */
  public static final String KEY_HADOOP_CONFIGURED_NODE_MAPPING =
      "hadoop.configured.node.mapping";

  /**
   * Configure the mapping by extracting any mappings defined in the
   * {@link #KEY_HADOOP_CONFIGURED_NODE_MAPPING} field
   * @param conf new configuration
   */
  public void setConf(Configuration conf) {
    if (conf != null) {
      String[] mappings = conf.getStrings(KEY_HADOOP_CONFIGURED_NODE_MAPPING);
      if (mappings != null) {
        for (String str : mappings) {
          String host = str.substring(0, str.indexOf('='));
          String rack = str.substring(str.indexOf('=') + 1);
          addNodeToRack(host, rack);
        }
      }
    }
  }

  /**
   * retained lower case setter for compatibility reasons; relays to
   * {@link #setConf(Configuration)}
   * @param conf new configuration
   */
  public void setconf(Configuration conf) {
    setConf(conf);
  }

  /* Only one instance per JVM */
  private static final Map<String, String> nameToRackMap = new HashMap<String, String>();

  /**
   * Add a node to the static map. The moment any entry is added to the map,
   * the map goes multi-rack.
   * @param name node name
   * @param rackId rack ID
   */
  public static void addNodeToRack(String name, String rackId) {
    synchronized (nameToRackMap) {
      nameToRackMap.put(name, rackId);
    }
  }

  public List<String> resolve(List<String> names) {
    List<String> m = new ArrayList<String>();
    synchronized (nameToRackMap) {
      for (String name : names) {
        String rackId;
        if ((rackId = nameToRackMap.get(name)) != null) {
          m.add(rackId);
        } else {
          m.add(NetworkTopology.DEFAULT_RACK);
        }
      }
      return m;
    }
  }



  /**
   * Get a copy of the map (for diagnostics)
   * @return a clone of the map or null for none known
   */
  public Map<String, String> getSwitchMap() {
    synchronized (nameToRackMap) {
      return new HashMap<String, String>(nameToRackMap);
    }
  }

  @Override
  public String toString() {
    return "static mapping with single switch = ";
  }

  /**
   * Clear the map
   */
  public static void resetMap() {
    synchronized (nameToRackMap) {
      nameToRackMap.clear();
    }
  }
  
  public void reloadCachedMappings() {
    
  }

  public void reloadCachedMappings(List<String> names) {
    
  }
}
