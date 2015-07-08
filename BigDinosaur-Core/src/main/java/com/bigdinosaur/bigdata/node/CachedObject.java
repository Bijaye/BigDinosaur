package com.bigdinosaur.bigdata.node;

public interface CachedObject {

    CachedObject[] emptyArray = new CachedObject[]{};

    boolean isMemory();

    void updateAccessCount(int count);

    int getAccessCount();

    void setStorageSize(int size);

    int getStorageSize();

    boolean isBlock();

    long getPos();

    void setPos(long pos);

    boolean isNew();

    boolean hasChanged();

    boolean isKeepInMemory();

    boolean keepInMemory(boolean keep);

    boolean isInMemory();

    void setInMemory(boolean in);

    void restore();

    void destroy();

    int getRealSize(RowOutputInterface out);

    void read(RowInputInterface in);

    int getDefaultCapacity();

    void write(RowOutputInterface out);

}
