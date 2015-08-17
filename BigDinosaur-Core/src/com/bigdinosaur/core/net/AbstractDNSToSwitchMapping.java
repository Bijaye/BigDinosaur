package com.bigdinosaur.core.net;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.bigdinosaur.config.CommonConfigurationKeys;
import com.bigdinosaur.config.Configurable;
import com.bigdinosaur.config.Configuration;


public abstract class AbstractDNSToSwitchMapping
    implements DNSToSwitchMapping, Configurable {

  private Configuration conf;

  /**
   * Create an unconfigured instance
   */
  protected AbstractDNSToSwitchMapping() {
  }

  /**
   * Create an instance, caching the configuration file.
   * This constructor does not call {@link #setConf(Configuration)}; if
   * a subclass extracts information in that method, it must call it explicitly.
   * @param conf the configuration
   */
  protected AbstractDNSToSwitchMapping(Configuration conf) {
    this.conf = conf;
  }

  @Override
  public Configuration getConf() {
    return conf;
  }

  @Override
  public void setConf(Configuration conf) {
    this.conf = conf;
  }

  /**
   * Predicate that indicates that the switch mapping is known to be
   * single-switch. The base class returns false: it assumes all mappings are
   * multi-rack. Subclasses may override this with methods that are more aware
   * of their topologies.
   *
   * <p/>
   *
   * This method is used when parts of Hadoop need know whether to apply
   * single rack vs multi-rack policies, such as during block placement.
   * Such algorithms behave differently if they are on multi-switch systems.
   * </p>
   *
   * @return true if the mapping thinks that it is on a single switch
   */
  public boolean isSingleSwitch() {
    return false;
  }

  /**
   * Get a copy of the map (for diagnostics)
   * @return a clone of the map or null for none known
   */
  public Map<String, String> getSwitchMap() {
    return null;
  }

  /**
   * Generate a string listing the switch mapping implementation,
   * the mapping for every known node and the number of nodes and
   * unique switches known about -each entry to a separate line.
   * @return a string that can be presented to the ops team or used in
   * debug messages.
   */
  public String dumpTopology() {
    Map<String, String> rack = getSwitchMap();
    StringBuilder builder = new StringBuilder();
    builder.append("Mapping: ").append(toString()).append("\n");
    if (rack != null) {
      builder.append("Map:\n");
      Set<String> switches = new HashSet<String>();
      for (Map.Entry<String, String> entry : rack.entrySet()) {
        builder.append("  ")
            .append(entry.getKey())
            .append(" -> ")
            .append(entry.getValue())
            .append("\n");
        switches.add(entry.getValue());
      }
      builder.append("Nodes: ").append(rack.size()).append("\n");
      builder.append("Switches: ").append(switches.size()).append("\n");
    } else {
      builder.append("No topology information");
    }
    return builder.toString();
  }

  protected boolean isSingleSwitchByScriptPolicy() {
    return conf != null
        && conf.get(CommonConfigurationKeys.NET_TOPOLOGY_SCRIPT_FILE_NAME_KEY) == null;
  }

  /**
   * Query for a {@link DNSToSwitchMapping} instance being on a single
   * switch.
   * <p/>
   * This predicate simply assumes that all mappings not derived from
   * this class are multi-switch.
   * @param mapping the mapping to query
   * @return true if the base class says it is single switch, or the mapping
   * is not derived from this class.
   */
  public static boolean isMappingSingleSwitch(DNSToSwitchMapping mapping) {
    return mapping != null && mapping instanceof AbstractDNSToSwitchMapping
        && ((AbstractDNSToSwitchMapping) mapping).isSingleSwitch();
  }

}
