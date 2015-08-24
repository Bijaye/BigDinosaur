package com.bigdinosaur.core.fs;

import java.io.IOException;

import com.bigdinosaur.cluster.acl.FsPermission;





class ViewFsFileStatus extends FileStatus {
   final FileStatus myFs;
   Path modifiedPath;
   ViewFsFileStatus(FileStatus fs, Path newPath) {
     myFs = fs;
     modifiedPath = newPath;
   }
   
   @Override
   public boolean equals(Object o) {
     return super.equals(o);
   }
   
   @Override
  public int hashCode() {
     return super.hashCode();
   }
   
   @Override
   public long getLen() {
     return myFs.getLen();
   }

   @Override
   public boolean isFile() {
     return myFs.isFile();
   }

   @Override
   public boolean isDirectory() {
     return  myFs.isDirectory();
   }
   
   @Override
   @SuppressWarnings("deprecation")
   public boolean isDir() {
     return myFs.isDirectory();
   }
   
   @Override
   public boolean isSymlink() {
     return myFs.isSymlink();
   }

   @Override
   public long getBlockSize() {
     return myFs.getBlockSize();
   }

   @Override
   public short getReplication() {
     return myFs.getReplication();
   }

   @Override
   public long getModificationTime() {
     return myFs.getModificationTime();
   }

   @Override
   public long getAccessTime() {
     return myFs.getAccessTime();
   }

   @Override
   public String getPermission() {
     return myFs.getPermission();
   }
   
   @Override
   public String getOwner() {
     return myFs.getOwner();
   }
   
   @Override
   public String getGroup() {
     return myFs.getGroup();
   }
   
   @Override
   public Path getPath() {
     return modifiedPath;
   }
   
   @Override
   public void setPath(final Path p) {
     modifiedPath = p;
   }

   @Override
   public Path getSymlink() throws IOException {
     return myFs.getSymlink();
   }
}

