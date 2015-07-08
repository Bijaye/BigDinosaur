package com.bigdinosaur.bigdata.io;





public class RowOutputBinaryEncode extends RowOutputBinary {

    final Crypto crypto;

    public RowOutputBinaryEncode(Crypto crypto, int initialSize, int scale) {

        super(initialSize, scale);

        this.crypto = crypto;
    }

    public void writeData(Row row, Type[] types) {

        if (crypto == null) {
            super.writeData(row, types);
        } else {
            int start = count;

            ensureRoom(row.getStorageSize());
            writeInt(0);
            super.writeData(row, types);

            int origLength = count - start - INT_STORE_SIZE;
            int newLength = crypto.encode(buffer, start + INT_STORE_SIZE,
                                          origLength, buffer,
                                          start + INT_STORE_SIZE);

            writeIntData(newLength, start);

            count = start + INT_STORE_SIZE + newLength;
        }
    }

    /**
     *  Calculate the size of byte array required to store a row.
     *
     * @param  row - a database row
     * @return  size of byte array
     * @exception  HsqlException When data is inconsistent
     */
    public int getSize(Row row) {

        int size = super.getSize(row);

        if (crypto != null) {
            size = crypto.getEncodedSize(size - INT_STORE_SIZE)
                   + INT_STORE_SIZE * 2;
        }

        return size;
    }

    public RowOutputInterface duplicate() {
        return new RowOutputBinaryEncode(crypto, 128, this.scale);
    }
}
