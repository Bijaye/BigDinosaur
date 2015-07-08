package com.base.easy.da;

import java.util.List;

public class ExcelServiceDto {

	private byte[] excel;

	private List<Object> dataList;

	public byte[] getExcel() {
		return excel;
	}

	public void setExcel(byte[] excel) {
		this.excel = excel;
	}

	public List<Object> getDataList() {
		return dataList;
	}

	public void setDataList(List<Object> dataList) {
		this.dataList = dataList;
	}

}
