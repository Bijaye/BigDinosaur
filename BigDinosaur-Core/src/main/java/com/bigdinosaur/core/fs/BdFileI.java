package com.bigdinosaur.core.fs;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.bigdinosaur.core.database.BdFile;

public class BdFileI
{

  public static void moveBdfObject(BdFile bdfile)
  {
    File source = new File(bdfile.getDirlocation());

    String foldername = getFolderName();
    File dest = getDestinationFolder(foldername);
    boolean successful = dest.mkdirs();
    if (successful)
    {
    }
    else
    {
    }

    if (dest.exists())
    {
      try
      {
        FileUtils.copyDirectory(source, dest);
      }
      catch (IOException e)
      {
      }
    }
    try
    {
      // delete(source);
      CreateTomcatLogFile();

    }
    catch (Exception e)
    {

    }

  }

  private static File getDestinationFolder(String foldername)
  {
    // /mnt/pd0/logs/ it is root of folder
    File dest = new File("/mnt/pd0/logs/" + foldername);
    return dest;
  }

  private static String getFolderName()
  {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date date = new Date();
    String foldername = dateFormat.format(date);
    return foldername;
  }

  public static void delete(File file) throws IOException
  {

    if (file.isDirectory())
    {

      if (file.list().length == 0)
      {

        file.delete();

      }
      else
      {

        String files[] = file.list();

        for (String temp : files)
        {
          File fileDelete = new File(file, temp);

          delete(fileDelete);
        }

        if (file.list().length == 0)
        {
          file.delete();
        }
      }

    }
    else
    {
      // if file, then delete it
      file.delete();
    }
  }

  static void CreateTomcatLogFile() throws IOException
  {
    File filelog = new File("C://input");
    if (!filelog.exists())
    {
      if (filelog.mkdir())
      {
      }
      else
      {
      }
    }

  }
}
