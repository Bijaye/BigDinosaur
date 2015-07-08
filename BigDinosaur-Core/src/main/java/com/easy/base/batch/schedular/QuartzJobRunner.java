package com.easy.base.batch.schedular;



import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.base.easy.batch.BatchRunner;


public class QuartzJobRunner extends QuartzJobBean {
	private BatchRunner schedularJob;

	public BatchRunner getSchedularJob() {
		return schedularJob;
	}

	public void setSchedularJob(BatchRunner schedularJob) {
		this.schedularJob = schedularJob;
	}

	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

		try {
			
			String[] array = new String[4];
			array[0] = "";
			array[1] = "";
			array[2] = "";
			schedularJob.executeService(array);
		} catch (Exception e) {
			e.printStackTrace();

		}
		;

	}
}