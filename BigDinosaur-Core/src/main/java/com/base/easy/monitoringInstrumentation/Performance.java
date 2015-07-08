package com.base.easy.monitoringInstrumentation;

import java.util.List;

public interface Performance {
	Performance getPerformanceLevel();
	List<Performance>getPerformanceLevelAccumulated();
	Performance GetPerformanceLevelController();
	Performance GetPerformanceLevelService();
	Performance GetPerformanceLevelDao();
	Performance GetPerformanceLevelQuery();
	Performance GetJvmStatus();
	Performance GetMaxThreadsNoCpatured();
	Performance GetDetaiViewOfExecutionAllLayer();
	Performance GetDetaiViewOfLayer();
	Performance getAlertForResourceDeficiency();
	

}
