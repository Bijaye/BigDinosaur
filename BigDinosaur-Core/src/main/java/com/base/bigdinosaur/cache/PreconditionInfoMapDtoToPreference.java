package com.base.bigdinosaur.cache;

import java.util.Map;

public class PreconditionInfoMapDtoToPreference {
	private Map preconditionMap;
	   private String preConditionId;
       private String preConditionValue;
       private String preConditionType;
       private Map PreferenceMap;

	public PreconditionInfoMapDtoToPreference() {
		preconditionMap = null;
	}

	public Map getPreconditionMap() {
		return preconditionMap;
	}

	public void setPreconditionMap(Map preconditionMap) {
		this.preconditionMap = preconditionMap;
	}

	public String getPreConditionId() {
		return preConditionId;
	}

	public String getPreConditionValue() {
		return preConditionValue;
	}

	public String getPreConditionType() {
		return preConditionType;
	}

	public Map getPreferenceMap() {
		return PreferenceMap;
	}

	public void setPreConditionId(String preConditionId) {
		this.preConditionId = preConditionId;
	}

	public void setPreConditionValue(String preConditionValue) {
		this.preConditionValue = preConditionValue;
	}

	public void setPreConditionType(String preConditionType) {
		this.preConditionType = preConditionType;
	}

	public void setPreferenceMap(Map preferenceMap) {
		PreferenceMap = preferenceMap;
	}

}
