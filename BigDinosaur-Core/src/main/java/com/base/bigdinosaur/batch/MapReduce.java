package com.base.bigdinosaur.batch;


import java.util.Collection;
import java.util.Map;

public interface MapReduce {
	Map getmap();
	Reduce getReduce();
	// There can be multiple criteria can be set for processing for data .
	Collection getCriteria(Collection collection);
	boolean ConvertToRelational(OrmObject orm);

}
