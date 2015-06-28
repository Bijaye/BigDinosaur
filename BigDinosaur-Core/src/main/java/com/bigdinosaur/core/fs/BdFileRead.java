package com.bigdinosaur.core.fs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bigdinosaur.core.database.BdMap;

public class BdFileRead
{

  public BdMap readFile(String url){
    BufferedReader br = null;
    try {
 
      String sCurrentLine;
      BdMap map= BdMap.get();
      br = new BufferedReader(new FileReader(url));
 
      while ((sCurrentLine = br.readLine()) != null) {
        String current;
       
        System.out.println(sCurrentLine);
        String[] array=   sCurrentLine.split(" ");
        for(int i=0;i<=array.length;i++){
          System.out.println(array[i]);
          
//        for (int i = 0;i < array[i].length(); i++){
//          System.out.println(sCurrentLine.charAt(i));
//      }
        int ii=1;
        if(array[i].equals(array[i-1])){
        map.add(ii++, sCurrentLine);
      }
        }
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
