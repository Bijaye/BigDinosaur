package com.base.easy.batch.asychronous.batching;

import java.util.Collection;

public interface GetAsychronousTask<AsychronousBatch> {
	// Every batch id has single instance of AsychronousBatch object ,so i am returning collection .As,a framework it must be able to Handle as many as batch task irrespective of server,location .Just it care about where data is resides .
	Collection<AsychronousBatch> getAsychronousbatchList();

}
