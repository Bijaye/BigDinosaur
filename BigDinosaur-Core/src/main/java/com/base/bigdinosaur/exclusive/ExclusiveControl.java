package com.base.bigdinosaur.exclusive;

public interface ExclusiveControl {
	public abstract Object lock(String key, String refKey, String fileId,
			String exclusiveKey1, String exclusiveKey2, String workStationId,
			String moduleid, String packageid, String businessid);

	public abstract Object unlock(String key, String refKey, String fileId,
			String exclusiveKey1, String exclusiveKey2, String workStationId,
			String moduleid, String packageid, String businessid,
			String repoid, String documentid);

}
