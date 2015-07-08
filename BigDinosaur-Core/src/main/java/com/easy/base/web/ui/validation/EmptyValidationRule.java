package com.easy.base.web.ui.validation;

import org.springmodules.validation.bean.rule.AbstractValidationRule;
import org.springmodules.validation.util.condition.Condition;

import com.easy.base.web.val.impl.SimpleExSpring;


public class EmptyValidationRule extends AbstractValidationRule{

	protected EmptyValidationRule(String defaultErrorCode) {
		
		super("eay.empty");
	
	}

	@Override
	public Condition getCondition() {
		return SimpleExSpring.EmptyImpl();
	}

}
