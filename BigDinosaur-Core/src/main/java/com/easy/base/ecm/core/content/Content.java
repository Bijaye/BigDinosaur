package com.easy.base.ecm.core.content;

import java.util.List;

import com.easy.base.ecm.core.contentrepo.QueryContentRepo;

public interface Content {
	Content getContent();
	void setContent(Content content);
	Content getContentList();
	void setContentList(List<Content> content);
	QueryContentRepo getContentListQuery();
	void setContentListQuery(QueryContentRepo repo);
	

}
