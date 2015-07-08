package com.base.easy.utility;

public enum CommanEnum {

	INISIATIATE_CREATE(CommonConstant.CREATE_REPO), INISIATIATE_REVISION(""), REVISION(
			""), INISIATIATE_CANCEL(""), CANCEL(""), POST_CREATE(""), POST_UPDATE(
			""), POST_DELETE(""), POST_READ(""), POST_CANCEL("");
	private String value;

	private CommanEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
