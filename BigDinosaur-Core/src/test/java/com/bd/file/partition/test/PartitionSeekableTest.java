package com.bd.file.partition.test;

import java.io.IOException;
import java.io.RandomAccessFile;

import junit.framework.Assert;

import org.junit.Test;

import com.bigdinosaur.core.fs.BdPartition;
import com.bigdinosaur.core.fs.BdSeekable;

public class PartitionSeekableTest
{
  @Test
public void SeekableTest() throws IOException{
   RandomAccessFile raf = new RandomAccessFile("D://test.txt", "rw");
   BdSeekable seek=new BdSeekable(0,10);
   BdPartition partitin=new BdPartition();
   byte[]  read=partitin.read(seek, raf);
   Assert.assertEquals(10, read.length);
   
   
}

}
