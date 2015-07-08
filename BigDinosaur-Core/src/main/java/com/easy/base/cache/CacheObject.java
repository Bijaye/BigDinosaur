package com.easy.base.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheObject {
	 private Map cacheMap;
	

		private final Map map = new HashMap();
		private List objectCacheList;
	public CacheObject() {
		objectCacheList = new ArrayList();
		  cacheMap = new HashMap();
	}

	private Map getObjectCacheMap() {
		if (map.entrySet().size() == 0) {
			cacheMessage();
		}
		return map;
	}

	private String getMapKey(String programId) {
		return programId;

	}

	public String getMessage(String messageId) {
		// return on the basis of context
		return "";
	}

	public Map getMessageInfo(String messageId) {
		Map b = (Map) getObjectCacheMap().get(messageId);
		if (b == null) {
			{
				getObjectCacheMap().put(messageId, "");
			}
		}
		return b;
	}

	private void cacheMessage() {
		Object cache = (Object)cacheMap.get("key");
		           if(cache == null)
		           {
		              Object tobecache=new Object();
		              // set program id on tobecache and call service with tobecache as paramter
		             
		               cacheMap.put(getMapKey("programid"), cache);
		                    }

		// map.putAll(dto.getMessageMap());
	}

	public List getMessageCacheList() {
		return objectCacheList;
	}

	public void setMessageCacheList(List messageCacheList) {
		this.objectCacheList = messageCacheList;
	}

}
