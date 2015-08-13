package com.base.bigdinosaur.cache;

public interface Cachable {
	void putData(Object object);

	public abstract Object getData(Object object);

	public abstract void putDataDistributed(Object object);

	public abstract Object getDataDistributed(Object object);

	public abstract void fetchByProgramId(String s);

	public abstract void fetchByProgramId(String s, boolean flag);

	public abstract void fetchByScreenId(String s);

	public abstract void fetchByScreenId(String s, boolean flag);

	public abstract void clear();

	public abstract String getFieldName(String programId, String fieldId);

}
