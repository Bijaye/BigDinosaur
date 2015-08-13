package org.bigdinosaur.core.database;

public interface BdGraphType
{
  static final String bdnode="BdHost node";
 // Host node:Represents a physical computer (hardware) and a collection of hardwares 
  //that the rest of the nodes (subnodes) reside on.
 // Module node
  
  //tree view of available modules
  static final String bdnodemodule="BdModule node";
  // bdfilesystem slightly differentiate with bddfs(Big Dinosaur Distributed file system)
  //Represents the top level of a tree view of the host file system. File system subnodes represent drives
//  and locations on the host system. File system provides access
  //to files that are outside of the host via some interfaces 
  static final String BdFilesystemnode=" BdFile system node";
  //BdFilesystemnode<---------> interfaces with bddfs
  
  //displays a content of Bdclusternodesinglestation on hierarchical order  
  static final String Bdclusternodesingleststaione=" Bdclusternodesinglestation";
  
 
}
