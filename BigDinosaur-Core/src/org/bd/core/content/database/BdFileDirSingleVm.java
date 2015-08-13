package org.bd.core.content.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// it is single node three 
//depth of nodes goes on increasing 
//assumption  of implementation 
// latest data is on high depth node 
////////////////Note /////////////////////
//Folder structure is written in file folderstrcuturetestedfor


//visualize in terms of file system 
// DdTree gives all objects of file system 
public class BdFileDirSingleVm
{
  // it is the case for loading object in memory .All file objects exists in memory in tree forms 
  public BdFileDirSingleVm  getInMemoryDatabase(String[] args)
  {
    //for first file 
     
    BdFileDirSingleVm tree=new BdFileDirSingleVm();
    tree.setEncryptedfilename("99494949");
    //this value is refilecontentastokenaslist come by calling BdFilewalker.read();
    //this is for dummy purpose 
    tree.setFilecontentastokenaslist(new ArrayList<ArrayList<BdFileContent>>());
    
  //this value is refilecontentastokenaslist come by calling BdFilewalker.read();
    //this is for dummy purpose 
    
    tree.setFilecontentkeyvalueasmap(new HashMap<String, Map<String,BdFileContent>>());
    tree.setFiledirectory("D://database");
    tree.setFileid("1000");
    
    
    
    
    
    
    
    // for second file 
    
    BdFileDirSingleVm nextfile=  tree.nextfile;
    nextfile.setEncryptedfilename("99494940");
    nextfile.setFiledirectory("D://database//fileindex/fileindex.txt");
    // setFilecontentastokenaslist is the content of fileindex.txt in arraylist as all tokens 
    nextfile.setFilecontentastokenaslist(new ArrayList<ArrayList<BdFileContent>>());
    
    nextfile.setFileid("1001");
    // setFilecontentastokenaslist is the content of fileindex.txt in map as key value  
    nextfile.setFilecontentkeyvalueasmap(new HashMap<String, Map<String,BdFileContent>>());
    
    
    
    
    // for third file 
    
    BdFileDirSingleVm nextfile2=nextfile.getNextfile();
    nextfile2.setEncryptedfilename("99494943");
    nextfile.setFiledirectory("D://database//user/user.txt");
 // setFilecontentastokenaslist is the content of user.txt
    nextfile2.setFilecontentastokenaslist(new ArrayList<ArrayList<BdFileContent>>());
    nextfile2.setFileid("1002");
 // setFilecontentastokenaslist is the content of user.txt in map as key value  
    nextfile2.setFilecontentkeyvalueasmap(new HashMap<String, Map<String,BdFileContent>>());
    
    
    BdFileDirSingleVm nextfile3= nextfile2.getNextfile();
    nextfile3.setFiledirectory("D://database//user//likes//likes.txt");
    // and  similiar process for all 
    return nextfile3;
    
    
    
    
    
    
    
    
    
    
    
  }
  // it loads all contents of files in the form of strings
  // Though this might be right option but i dont have choice now.It need to be more optimized and refined
  // each object of BdFileContent is tokens 
  String filename;
 List<ArrayList<BdFileContent>> filecontentastokenaslist=new  ArrayList<ArrayList<BdFileContent>>();
 Map<String,Map<String,BdFileContent>> filecontentkeyvalueasmap=new   HashMap<String, Map<String,BdFileContent>>();
 String filedirectory;
 String fileid;
 String encryptedfilename;
 
 BdFileDirSingleVm nextfile=new BdFileDirSingleVm();

 
 BdFileDirSingleVm getInMemoryTree(){
   BdFileDirSingleVm tree=new BdFileDirSingleVm();
   return tree.getInMemoryDatabase(new String[2]);
   
   
 }
 String SearchOnInMemoryDataBase(String userid){
   BdFileDirSingleVm tree=new BdFileDirSingleVm(); getInMemoryTree();
   //recursively search data on tree 
  return userid;
  
   
 }

public String getFilename()
{
  return filename;
}

public List<ArrayList<BdFileContent>> getFilecontentastokenaslist()
{
  return filecontentastokenaslist;
}

public Map<String, Map<String, BdFileContent>> getFilecontentkeyvalueasmap()
{
  return filecontentkeyvalueasmap;
}

public String getFiledirectory()
{
  return filedirectory;
}

public String getFileid()
{
  return fileid;
}

public String getEncryptedfilename()
{
  return encryptedfilename;
}

public BdFileDirSingleVm getNextfile()
{
  return nextfile;
}

public void setFilename(String filename)
{
  this.filename = filename;
}

public void setFilecontentastokenaslist(List<ArrayList<BdFileContent>> filecontentastokenaslist)
{
  this.filecontentastokenaslist = filecontentastokenaslist;
}

public void setFilecontentkeyvalueasmap(Map<String, Map<String, BdFileContent>> filecontentkeyvalueasmap)
{
  this.filecontentkeyvalueasmap = filecontentkeyvalueasmap;
}

public void setFiledirectory(String filedirectory)
{
  this.filedirectory = filedirectory;
}

public void setFileid(String fileid)
{
  this.fileid = fileid;
}

public void setEncryptedfilename(String encryptedfilename)
{
  this.encryptedfilename = encryptedfilename;
}

public void setNextfile(BdFileDirSingleVm nextfile)
{
  this.nextfile = nextfile;
}

}
