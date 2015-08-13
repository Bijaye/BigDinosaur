package org.bigdinosaur.core.database;

public abstract  class Bdfsystem
{

  String bdfsurl;
  int nooffiles;
  abstract Bdfsystem getrealPath();
  abstract Bdfsystem  getabsoultePath();
    abstract Bdfsystem  getrelativePath();
    abstract Bdfsystem  getBinaryPath();
    abstract Bdfsystem  getFolderName();
    abstract Bdfsystem  getObjectNameInternal();
    abstract Bdfsystem  getObjectNameExternal();
    abstract Bdfsystem  getObjectNameVirtual();
    abstract Bdfsystem  getObjectNameReal();
    abstract  boolean isLocalRepo();
    abstract boolean isCloudRepo();
    abstract Bdfsystem getLocalStorageLineage();
    abstract  Bdfsystem getCloudStorageLinegae();
}
