package com.easy.base.action.rule.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharsetRule {

	public CharsetRule() {
		pattern = null;
	}

	public CharsetRule(String regexp) {
		pattern = null;
		pattern = Pattern.compile(regexp);
	}

	public boolean isValid(String value) {
		if (value == null) {
			return true;
		} else {
			Matcher matcher = pattern.matcher(value);
			return matcher.matches();
		}
	}

	
	private Pattern pattern;

}
