package com.base.easy.cache;

public interface MessageCache {
	public abstract MessageInfoMapDto getMessageMap(MessageIdListDto messageidlistdto);

    public abstract MessageInfoMapDto getMessage(MessageIdListDto messageiddto);



}
