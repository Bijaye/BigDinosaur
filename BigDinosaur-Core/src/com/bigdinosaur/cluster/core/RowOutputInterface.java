package com.bigdinosaur.cluster.core;
/**
 * Public interface for writing the data for cluster.
 *

 */
public interface RowOutputInterface extends Cloneable {

    void writeEnd();

    void writeSize(int size);

    void writeType(int type);

    void writeString(String value);

    void writeByte(int i);

    void writeChar(int i);

    void writeShort(int i);

    void writeInt(int i);

    void writeIntData(int i, int position);

    void writeLong(long i);

    void writeData(Object row, Type[] types);

                  

    int getSize(Object row);

    int getStorageSize(int size);


    byte[] getBuffer();

    void reset();

    void reset(int newSize);

    void reset(byte[] mainBuffer);

    // returns the current size
    int size();

    RowOutputInterface duplicate();
}