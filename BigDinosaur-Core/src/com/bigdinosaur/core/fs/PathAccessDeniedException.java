package com.bigdinosaur.core.fs;



public class PathAccessDeniedException extends PathIOException {
  static final long serialVersionUID = 0L;
  /** @param path for the exception */
  public PathAccessDeniedException(String path) {
    super(path, "Permission denied");
  }
}