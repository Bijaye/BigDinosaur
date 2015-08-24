package com.bigdinosaur.core.io;


public enum ReadOption {
  /**
   * Skip checksums when reading.  This option may be useful when reading a file
   * format that has built-in checksums, or for testing purposes.
   */
  SKIP_CHECKSUMS,
}
