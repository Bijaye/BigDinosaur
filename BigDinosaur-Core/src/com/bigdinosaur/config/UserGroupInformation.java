package com.bigdinosaur.config;

import java.io.IOException;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;

public class UserGroupInformation<T>
{

  public static UserGroupInformation getBestUGI(String ticketCachePath, String user)
                                                                                    throws IOException
  {
    if (ticketCachePath != null)
    {
      return getUGIFromTicketCache(ticketCachePath, user);
    }
    else if (user == null)
    {
      return getCurrentUser();
    }
    else
    {
      return createRemoteUser(user);
    }
  }

  public static UserGroupInformation getUGIFromTicketCache(String ticketCache, String user)
  {
    return null;

  }

  static UserGroupInformation getCurrentUser() throws IOException
  {
    return null;

  }

  public static UserGroupInformation createRemoteUser(String user)
  {
    return null;
  }

  public <T> T doAs(PrivilegedAction<T> action)
  {
    return null;

  }

  public <T> T doAs(PrivilegedExceptionAction<T> action) throws IOException, InterruptedException
  {
return null;
  }

}
