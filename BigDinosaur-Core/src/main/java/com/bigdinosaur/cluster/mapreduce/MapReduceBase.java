package com.bigdinosaur.cluster.mapreduce;

import java.io.Closeable;
import java.io.IOException;

/** 
 * Base class for  Mapper} and  Reducer} implementations.
 * 
 * <p>Provides default no-op implementations for a few methods, most non-trivial
 * applications need to override some of them.</p>
 */
public class MapReduceBase implements Closeable, JobConfigurable {

  /** Default implementation that does nothing. */
  public void close() throws IOException {
  }

  /** Default implementation that does nothing. */
  public void configure(JobConf job) {
  }

}
