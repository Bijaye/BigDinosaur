package com.bigdinosaur.config;

import java.io.IOException;
import java.net.URI;
import java.security.PrivilegedExceptionAction;

import com.bigdinosaur.core.fs.Path;
public abstract class FileSystem
{
  
  public static FileSystem get(final URI uri, final BdConfiguration conf,
                               final String user) throws IOException, InterruptedException {
                           String ticketCachePath =
                             conf.get(CommonConfigurationKeys.KERBEROS_TICKET_CACHE_PATH);
                           UserGroupInformation ugi =
                               UserGroupInformation.getBestUGI(ticketCachePath, user);
                           return ugi.doAs(new PrivilegedExceptionAction<FileSystem>() {
                             @Override
                             public FileSystem run() throws IOException, InterruptedException {
                               return get(uri, conf,"abishkar");
                             }
                           });
                         }
  
  
  public abstract URI getUri();
  public abstract Path getWorkingDirectory();
  public abstract Object getFileStatus(Path f) throws IOException;

}
