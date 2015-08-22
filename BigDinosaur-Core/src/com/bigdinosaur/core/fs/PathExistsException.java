package com.bigdinosaur.core.fs;



/**
 * Exception corresponding to File Exists - EEXISTS
 */
public class PathExistsException extends PathIOException {
  static final long serialVersionUID = 0L;
  /** @param path for the exception */
  public PathExistsException(String path) {
    super(path, "File exists");
  }
  
  protected PathExistsException(String path, String error) {
    super(path, error);
  }
}