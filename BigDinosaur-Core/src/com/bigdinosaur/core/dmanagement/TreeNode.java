package com.bigdinosaur.core.dmanagement;

import java.util.ArrayList;
import java.util.List;

import com.bigdinosaur.clusters.assimpletree.ClustersSimpleTree;



public class TreeNode
{
private String foldername;
TreeNode parentNode;
// Programming by optimization 
ClustersSimpleTree pbo;
List<TreeNode> childNodes = new ArrayList();
public String getFoldername()
{
  return foldername;
}
public TreeNode(String foldername, boolean isroot, boolean isleft, boolean isright,
                     boolean issinlgebranchtree, boolean isleaf, byte foldercontent,
                     String foldercontentencryptkey, String foldercontentdecryptkey,
                     String folderpath, String folderpathabsolute, String folderpathrelative,
                     ArrayList<TreeNode> asssemblingnode)
{
  this.foldername = foldername;
  this.isroot = isroot;
  this.isleft = isleft;
  this.isright = isright;
  this.issinlgebranchtree = issinlgebranchtree;
  this.isleaf = isleaf;
  this.foldercontent = foldercontent;
  this.foldercontentencryptkey = foldercontentencryptkey;
  this.foldercontentdecryptkey = foldercontentdecryptkey;
  this.folderpath = folderpath;
  this.folderpathabsolute = folderpathabsolute;
  this.folderpathrelative = folderpathrelative;
  this.asssemblingnode = asssemblingnode;
}
public void setFoldername(String foldername)
{
  this.foldername = foldername;
}
public boolean isIsroot()
{
  return isroot;
}
public void setIsroot(boolean isroot)
{
  this.isroot = isroot;
}
public boolean isIsleft()
{
  return isleft;
}
public void setIsleft(boolean isleft)
{
  this.isleft = isleft;
}
public boolean isIsright()
{
  return isright;
}
public void setIsright(boolean isright)
{
  this.isright = isright;
}
public boolean isIssinlgebranchtree()
{
  return issinlgebranchtree;
}
public void setIssinlgebranchtree(boolean issinlgebranchtree)
{
  this.issinlgebranchtree = issinlgebranchtree;
}
public boolean isIsleaf()
{
  return isleaf;
}
public void setIsleaf(boolean isleaf)
{
  this.isleaf = isleaf;
}
public byte getFoldercontent()
{
  return foldercontent;
}
public void setFoldercontent(byte foldercontent)
{
  this.foldercontent = foldercontent;
}
public String getFoldercontentencryptkey()
{
  return foldercontentencryptkey;
}
public void setFoldercontentencryptkey(String foldercontentencryptkey)
{
  this.foldercontentencryptkey = foldercontentencryptkey;
}
public String getFoldercontentdecryptkey()
{
  return foldercontentdecryptkey;
}
public void setFoldercontentdecryptkey(String foldercontentdecryptkey)
{
  this.foldercontentdecryptkey = foldercontentdecryptkey;
}
public String getFolderpath()
{
  return folderpath;
}
public void setFolderpath(String folderpath)
{
  this.folderpath = folderpath;
}
public String getFolderpathabsolute()
{
  return folderpathabsolute;
}
public void setFolderpathabsolute(String folderpathabsolute)
{
  this.folderpathabsolute = folderpathabsolute;
}
public String getFolderpathrelative()
{
  return folderpathrelative;
}
public void setFolderpathrelative(String folderpathrelative)
{
  this.folderpathrelative = folderpathrelative;
}
public ArrayList<TreeNode> getAsssemblingnode()
{
  return asssemblingnode;
}
public void setAsssemblingnode(ArrayList<TreeNode> asssemblingnode)
{
  this.asssemblingnode = asssemblingnode;
}
private boolean isroot;
private boolean isleft;
private boolean isright;
private boolean issinlgebranchtree;;
private boolean isleaf;
private byte foldercontent;
private String foldercontentencryptkey;
private String foldercontentdecryptkey;
private String folderpath;
private String folderpathabsolute;
private String folderpathrelative;
private ArrayList<TreeNode> asssemblingnode=new ArrayList<TreeNode>();
}
