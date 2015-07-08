package com.bigdinosaur.filecache;



import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

import com.bigdinosaur.config.Configuration;

/**
 * Distribute application-specific large, read-only files efficiently.
 * 
 * DistributedCache is a facility provided by the Map-Reduce
 * framework to cache files (text, archives, jars etc.) needed by applications.
 * 
 * 
 * Applications specify the files, via urls (hdfs:// or http://) to be cached 
 * via the {@link com.bigdinosaur.mapred.JobConf}.
 * The DistributedCache assumes that the
 * files specified via hdfs:// urls are already present on the 
 * {@link FileSystem} at the path specified by the url.
 * 
 * The framework will copy the necessary files on to the slave node before 
 * any tasks for the job are executed on that node. Its efficiency stems from 
 * the fact that the files are only copied once per job and the ability to 
 * cache archives which are un-archived on the slaves. 
 *
 * DistributedCache can be used to distribute simple, read-only
 * data/text files and/or more complex types such as archives, jars etc. 
 * Archives (zip, tar and tgz/tar.gz files) are un-archived at the slave nodes. 
 * Jars may be optionally added to the classpath of the tasks, a rudimentary 
 * software distribution mechanism.  Files have execution permissions.
 * Optionally users can also direct it to symlink the distributed cache file(s)
 * into the working directory of the task.
 * 
 * DistributedCache tracks modification timestamps of the cache 
 * files. Clearly the cache files should not be modified by the application 
 * or externally while the job is executing.
 *    */
  public class DistributedCache {
  private static final long DEFAULT_CACHE_SIZE = 10737418240L;

  
  
  


  
  }

