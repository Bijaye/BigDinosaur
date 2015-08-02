package org.bd.core.content.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BdFilewalker {
  List<String> listofdir=new ArrayList<String>();

    public List<String> walk( String path ) {
     

        File root = new File( path );
        File[] list = root.listFiles();

      

        for ( File f : list ) {
            if ( f.isDirectory() ) {
                walk( f.getAbsolutePath() );
                System.out.println( "Dir:" + f.getAbsoluteFile() );
               
            }
            else {
                System.out.println( "File:" + f.getAbsoluteFile() );
                listofdir.add(f.getAbsolutePath());
            }
        }
        return listofdir;
    }
    
    
    
  static  ArrayList<ArrayList<BdFileContent>>  read(String filepath){
    ArrayList<BdFileContent> filecontentlisteachline=new    ArrayList<BdFileContent>();
    ArrayList<ArrayList<BdFileContent>> filecontentlisteachfile=new    ArrayList<ArrayList<BdFileContent>>();
      BufferedReader br = null;
      
      try {
   
        String sCurrentLine;
   
        br = new BufferedReader(new FileReader(filepath));
   
        while ((sCurrentLine = br.readLine()) != null) {
          String[] split=   sCurrentLine.split(" ");
          for(int i=0;i<split.length;i++){
          
                BdFileContent filecontent=new BdFileContent();
            filecontent.setFilecontent(  split[i]);
            filecontent.setFolderpath(filepath);
            filecontentlisteachline.add(filecontent);
            
          }
          
          filecontentlisteachfile.add(filecontentlisteachline);
          
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
      return filecontentlisteachfile;
    }

  
  
  
  static  Map<String,String>  readasMap(String filepath){
    Map<String,String> map = new HashMap<String,String>() ;
      BufferedReader br = null;
      
      try {
   
        String sCurrentLine;
   
        br = new BufferedReader(new FileReader(filepath));
   
        while ((sCurrentLine = br.readLine()) != null) {
          String[] split=   sCurrentLine.split(" ");
         
          
            map.put(split[0], split[1]);
            
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
      return map;
    }

  
  
  
  
  
  
  
    public static  ArrayList<ArrayList<ArrayList<BdFileContent>>> main(String args) {
        BdFilewalker fw = new BdFilewalker();
        ArrayList<ArrayList<ArrayList<BdFileContent>>> nodes = new ArrayList<ArrayList<ArrayList<BdFileContent>>>();
        
        List<String> listoffile= fw.walk("D://database" );
        for(int i=0;i<listoffile.size();i++){
          ArrayList<ArrayList<BdFileContent>> list=    read(listoffile.get(i));
          nodes.add(list);
        
          
          
        }
        System.out.println(nodes);
        return nodes;
    }
    public static void main(String[] args)
    {
      BdFilewalker fw = new BdFilewalker();
      ArrayList<ArrayList<ArrayList<BdFileContent>>> nodes = new ArrayList<ArrayList<ArrayList<BdFileContent>>>();
      
      List<String> listoffile= fw.walk("D://database" );
      for(int i=0;i<listoffile.size();i++){
        ArrayList<ArrayList<BdFileContent>> list=    read(listoffile.get(i));
        nodes.add(list);
      
        
        
      }
      System.out.println(nodes);
  }
    }

