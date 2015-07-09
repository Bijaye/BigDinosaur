package com.bigdinosaur.base.ecm.storage;

public interface Lineage {
	Lineage getrealPath();
	Lineage getabsoultePath();
	Lineage getrelativePath();
	Lineage getBinaryPath();
	Lineage getFolderName();
	Lineage getObjectNameInternal();
	Lineage getObjectNameExternal();
	Lineage getObjectNameVirtual();
	Lineage	getObjectNameReal();

}
