package com.bigdinosaur.core.fs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.bigdinosaur.core.database.BdMap;

public class BdFileRead
{

  BdMap readFile(String url){
    BufferedReader br = null;
    
    try {
 
      String sCurrentLine;
 
      br = new BufferedReader(new FileReader(url));
 
      while ((sCurrentLine = br.readLine()) != null) {
        System.out.println(sCurrentLine);
        int i=0;
        BdMap.get().add(i, sCurrentLine);
        i++;
      }
 
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (br != null)br.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return null;
  }
}
