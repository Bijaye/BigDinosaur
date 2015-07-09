package com.bigdinosaur.base.ecm.storage;

public interface Storage {
	boolean isLocalRepo();
	boolean isCloudRepo();
	Lineage getLocalStorageLineage();
	Lineage getCloudStorageLinegae();

}
