package com.bigdinosaur.config;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
public class FileSystem
{
  
  public static FileSystem get(final URI uri, final Configuration conf,
                               final String user) throws IOException, InterruptedException {
                           String ticketCachePath =
                             conf.get(CommonConfigurationKeys.KERBEROS_TICKET_CACHE_PATH);
                           UserGroupInformation ugi =
                               UserGroupInformation.getBestUGI(ticketCachePath, user);
                           return ugi.doAs(new PrivilegedExceptionAction<FileSystem>() {
                             @Override
                             public FileSystem run() throws IOException {
                               return get(uri, conf);
                             }
                           });
                         }
  
  
  

}
