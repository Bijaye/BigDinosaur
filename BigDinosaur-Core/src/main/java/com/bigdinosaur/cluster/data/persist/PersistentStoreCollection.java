package com.bigdinosaur.cluster.data.persist;

public interface PersistentStoreCollection
{
  PersistentStore getStore(Object key);

  void setStore(Object key, PersistentStore store);

  void release();
}
