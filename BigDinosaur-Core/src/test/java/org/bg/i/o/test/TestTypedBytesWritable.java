package org.bg.i.o.test;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bigdinosaur.core.streaming.TypedBytesWritable;

import junit.framework.TestCase;




public class TestTypedBytesWritable extends TestCase {

  public void testToString() {
    TypedBytesWritable tbw = new TypedBytesWritable();
    tbw.setValue(true);
    assertEquals("true", tbw.toString());
    tbw.setValue(12345);
    assertEquals("12345", tbw.toString());
    tbw.setValue(123456789L);
    assertEquals("123456789", tbw.toString());
    tbw.setValue((float) 1.23);
    assertEquals("1.23", tbw.toString());
    tbw.setValue(1.23456789);
    assertEquals("1.23456789", tbw.toString());
    tbw.setValue("random text");
    assertEquals("random text", tbw.toString());
  }

  public void testIO() throws IOException {
    TypedBytesWritable tbw = new TypedBytesWritable();
    tbw.setValue(12345);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    DataOutput dout = new DataOutputStream(baos);
    tbw.write(dout);
    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
    DataInput din = new DataInputStream(bais);
    TypedBytesWritable readTbw = new TypedBytesWritable();
    readTbw.readFields(din);
    assertEquals(tbw, readTbw);
  }

}
