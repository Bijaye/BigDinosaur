package com.easy.bass.access.core.client;

import io.buji.pac4j.ClientSubjectFactory;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;

public class EasyClientSubjectFactory extends ClientSubjectFactory{
	
	public Subject createSubject(SubjectContext context) {
		// provide easy framework specific token Behavior 

		return super.createSubject(context);
	}

}
