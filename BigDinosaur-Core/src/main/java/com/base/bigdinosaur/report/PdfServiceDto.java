package com.base.bigdinosaur.report;

import java.util.List;

public class PdfServiceDto  {


    private byte[] pdf;
    private String erppackageid;
    private String packagename;
    private String classname;
    private String methodname;
    private String projectlevel;
    private List<String> childframework;
    

    private List<Object> dataList;

    private String frameworkserviceprovider;
    public String getFrameworkserviceprovider() {
		return frameworkserviceprovider;
	}

	public String getErppackageid() {
		return erppackageid;
	}

	public String getPackagename() {
		return packagename;
	}

	public String getClassname() {
		return classname;
	}

	public String getMethodname() {
		return methodname;
	}

	public String getProjectlevel() {
		return projectlevel;
	}

	public List<Object> getDataList() {
		return dataList;
	}

	public void setFrameworkserviceprovider(String frameworkserviceprovider) {
		this.frameworkserviceprovider = frameworkserviceprovider;
	}

	public void setErppackageid(String erppackageid) {
		this.erppackageid = erppackageid;
	}

	public void setPackagename(String packagename) {
		this.packagename = packagename;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}

	public void setProjectlevel(String projectlevel) {
		this.projectlevel = projectlevel;
	}

	public void setDataList(List<Object> dataList) {
		this.dataList = dataList;
	}

	
   

    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }

    public List<String> getChildframework() {
		return childframework;
	}

	public void setChildframework(List<String> childframework) {
		this.childframework = childframework;
	}

	public byte[] getPdf() {
        return pdf;
    }

    

}
