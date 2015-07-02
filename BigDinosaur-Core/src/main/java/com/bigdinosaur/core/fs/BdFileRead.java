package com.bigdinosaur.core.fs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.bigdinosaur.core.database.BdMap;

public class BdFileRead
{

  public BdMap readFile(String url){
    BufferedReader br = null;
    BdMap map=null;
    ArrayList<BdMap> maplist=null;
    try {
 
      String sCurrentLine;
      map = BdMap.get();
      maplist  =new ArrayList<BdMap>();
      br = new BufferedReader(new FileReader(url));
 
      while ((sCurrentLine = br.readLine()) != null) {
       
        System.out.println(sCurrentLine);
        String[] array=   sCurrentLine.split(" ");
        for(int i=0;i<array.length;i++){
          System.out.println(array[i]);
          map.put(1, array[i]);
        }
        for(int i=0;i<array.length;i++){
          map.getKey(array[i]);
          System.out.println("<Reading from map>"+  map.getKey(array[i]));
        }
        BdMap     maptoreturn=null;
        
        for(int i=0;i<array.length;i++){
          System.out.println(array[i]);
          for(int j=i+1;j<array.length;++j){
            System.out.println("<Comapring"+ array[i]+"with"+array[j]);
            if(array[i].equals(array[j])){
             int key= (int) map.getKey(array[i]);
                  maptoreturn = BdMap.get();
             maptoreturn.put(key++, array[i]);
             maplist.add(maptoreturn);
             maptoreturn=null;
            
              
            }
            
          }
       
         
          
          
//        for (int i = 0;i < array[i].length(); i++){
//          System.out.println(sCurrentLine.charAt(i));
//      }
//        int ii=1;
//        if(array[i].equals(array[i-1])){
//        map.add(ii++, sCurrentLine);
      }
        
//        }
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
    map.setMaplist(maplist);
    return map;
  }

}
