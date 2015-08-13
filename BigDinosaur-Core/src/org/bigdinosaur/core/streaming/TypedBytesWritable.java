package org.bigdinosaur.core.streaming;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bigdinosaur.io.BytesWritable;



public class TypedBytesWritable extends BytesWritable {

  public TypedBytesWritable() {
    super();
  }

  public TypedBytesWritable(byte[] bytes) {
    super(bytes);
  }

  public void setValue(Object obj) {
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      TypedBytesOutput tbo = TypedBytesOutput.get(new DataOutputStream(baos));
      tbo.write(obj);
      byte[] bytes = baos.toByteArray();
      set(bytes, 0, bytes.length);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public Object getValue() {
    try {
      ByteArrayInputStream bais = new ByteArrayInputStream(getBytes());
      TypedBytesInput tbi = TypedBytesInput.get(new DataInputStream(bais));
      Object obj = tbi.read();
      return obj;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public Type getType() {
    byte[] bytes = getBytes();
    if (bytes == null || bytes.length == 0) {
      return null;
    }
    for (Type type : Type.values()) {
      if (type.code == (int) bytes[0]) {
        return type;
      }
    }
    return null;
  }

  public String toString() {
    return getValue().toString();
  }

}
