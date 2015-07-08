package com.base.easy.core.business;

public interface Business {
	Business getBusinessType();
	Business getBusiness();
	Business getBusinessPackages(String businesstype);
	Business getModulesList(String businesspackage);
	Business getModule(String programid);

}
