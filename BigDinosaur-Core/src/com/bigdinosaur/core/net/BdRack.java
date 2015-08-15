package com.bigdinosaur.core.net;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BdRack
{
  public boolean isSingleRack() {
    return false;
  }
  public Map<String, String> getRackMap() {
    return null;
  }
  public String dumpTopology() {
    // nodes is rack size 
    Map<String, String> rack = getRackMap();
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

}
