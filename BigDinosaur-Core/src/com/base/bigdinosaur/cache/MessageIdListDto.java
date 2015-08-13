package com.base.bigdinosaur.cache;

import java.util.List;

public class MessageIdListDto {
	private List messageIdList;
	 private String messageId;

	public MessageIdListDto() {
		messageIdList = null;
	}

	public List getMessageIdList() {
		return messageIdList;
	}

	public void setMessageIdList(List messageIdList) {
		this.messageIdList = messageIdList;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

}
