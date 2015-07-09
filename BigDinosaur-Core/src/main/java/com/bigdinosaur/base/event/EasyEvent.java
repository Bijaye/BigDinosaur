package com.bigdinosaur.base.event;

import java.util.List;

import org.springframework.context.ApplicationEvent;

public class EasyEvent extends ApplicationEvent {
	private List<Object> additionaleasy;

	public EasyEvent(Object source) {
		super(source);
	}

	public EasyEvent(Object source, List additionaleasy) {
		super(source);
		this.additionaleasy = additionaleasy;
	}

	public Object getSource() {

		return source;
	}

	public String toString() {
		return getClass().getName() + "[source=" + source + "]";
	}

	public List<Object> getAdditionaleasy() {
		return additionaleasy;
	}

	public void setAdditionaleasy(List<Object> additionaleasy) {
		this.additionaleasy = additionaleasy;
	}

}