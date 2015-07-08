package com.easy.base.event;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.ApplicationListener;

public class CustomEventHandler implements ApplicationListener<EasyEvent> {
	List processorlist = new ArrayList();

	@PostConstruct
	public void postConstruct() throws Exception {
		processorlist.add(new EasyEventProcessor());
		// perform initialization

	}

	public void onApplicationEvent(EasyEvent easyevent) {
		try {
			process(processorlist, easyevent);

		} catch (Exception e) {
		}
	}

	public void process(List processorList, EasyEvent easyevent)
			throws Exception {
		Iterator iterator = processorList.iterator();
		while (iterator.hasNext()) {
			EasyEventProcessor processor = (EasyEventProcessor) iterator.next();
			processor.processInfo(easyevent);

		}
	}
}