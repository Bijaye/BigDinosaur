package com.bigdinosaur.base.web.val.impl;

import org.springmodules.validation.util.condition.string.AbstractStringCondition;

public class EmptyImpl extends AbstractStringCondition {

	public EmptyImpl() {

	}

	protected boolean checkString(String text) {
		if (text == null || text.length() == 0) {
			return true;
		} else {
			return false;
		}

	}
}