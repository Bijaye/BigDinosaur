package com.easy.base.ecm.content.versioning.core;

import com.easy.base.ecm.core.contentrepo.QueryVersionHistory;

public interface Contentversioning {
	Vesion getContentversioning();
	Vesion getContentversioningHistory();
	Vesion getContentversioningListHistory(QueryVersionHistory history);
	
	

}
