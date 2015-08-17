package com.bigdinosaur.core.io;



public enum Type {

  // codes for supported types (< 50):
  BYTES(0),
  BYTE(1),
  BOOL(2),
  INT(3),
  LONG(4),
  FLOAT(5),
  DOUBLE(6),
  STRING(7),
  VECTOR(8),
  LIST(9),
  MAP(10),
  
  // application-specific codes (50-200):
  WRITABLE(50),
  
  // low-level codes (> 200):
  MARKER(255);

  final int code;

  Type(int code) {
    this.code = code;
  }
}