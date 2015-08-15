package com.bigdinosaur.core.net;



import java.util.List;

/**
 * An interface that must be implemented to allow pluggable
 * DNS-name/IP-address to RackID resolvers.
 *
 */

public interface BdDnsToSwitchMapping {

  public List<String> resolve(List<String> names);

  /**
   * Reload all of the cached mappings.
   *
   * If there is a cache, this method will clear it, so that future accesses
   * will get a chance to see the new data.
   */
  public void reloadCachedMappings();
  
  /**
   * Reload cached mappings on specific nodes.
   *
   * If there is a cache on these nodes, this method will clear it, so that 
   * future accesses will see updated data.
   */
  public void reloadCachedMappings(List<String> names);
}
