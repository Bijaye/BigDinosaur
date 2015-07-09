package com.base.bigdinosaur.core.access;
// for all service 
public interface AllServiceAcl {
	public abstract boolean checkPrivilege(String programID) ;
	// secret logic check ,object can be any of paramter like programid and many more 
	public  abstract String getOperationType(AllServiceAcl service, Object inputServiceDto);
          
    }


