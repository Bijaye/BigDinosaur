package com.bigdinosaur.base.ecm.content.versioning.core;

import com.bigdinosaur.base.ecm.core.contentrepo.QueryVersionHistory;

public interface Contentversioning {
	Vesion getContentversioning();
	Vesion getContentversioningHistory();
	Vesion getContentversioningListHistory(QueryVersionHistory history);
	
	

}
