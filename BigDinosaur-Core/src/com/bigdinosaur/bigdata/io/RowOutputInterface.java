package com.bigdinosaur.bigdata.io;



/**
 * Public interface for writing the data for a database row.
 *
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

    void writeData(Row row, Type[] types);

    void writeData(int l, Type[] types, Object[] data, HashMappedList cols,
                   int[] primarykeys);

    int getSize(Row row);

    int getStorageSize(int size);

    // returns the underlying HsqlByteArrayOutputStream
    HsqlByteArrayOutputStream getOutputStream();

    byte[] getBuffer();

    // resets the byte[] buffer, ready for processing new row
    void reset();

    // performs reset() and ensures byte[] buffer is at least newSize
    void reset(int newSize);

    // sets the byte[] buffer
    void reset(byte[] mainBuffer);

    // returns the current size
    int size();

    RowOutputInterface duplicate();
}
