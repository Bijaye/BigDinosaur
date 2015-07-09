package com.base.bigdinosaur.cache;

import java.util.HashMap;
import java.util.Map;

public class FieldNameDto {
	private String programId;
	private String language;
	private Map fieldNames;

	public FieldNameDto() {
		fieldNames = new HashMap();
	}

	public FieldNameDto(Map fieldNames) {
		this.fieldNames = fieldNames;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getFieldName(String fieldId) {
		return (String) fieldNames.get(fieldId);
	}

}
