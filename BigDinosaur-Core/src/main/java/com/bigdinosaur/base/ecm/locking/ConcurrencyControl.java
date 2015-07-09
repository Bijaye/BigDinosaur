package com.bigdinosaur.base.ecm.locking;

public interface ConcurrencyControl {
	boolean isLocked();
	boolean isUnlocked();
	ConcurrencyControl getLockingStatus();
	ConcurrencyControl getVersionSeries();

}
