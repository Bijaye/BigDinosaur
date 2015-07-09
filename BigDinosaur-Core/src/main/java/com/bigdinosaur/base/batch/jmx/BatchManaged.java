package com.bigdinosaur.base.batch.jmx;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
@ManagedResource(objectName = "mbeans:name=easyjmx", description = "BatchStatus.")
public class BatchManaged {
     
    private String cornexpression;
	   @ManagedAttribute(description = "get corn expression value")
	public String getCornexpression() {
		return cornexpression;
	}


	   @ManagedOperation(description = "set corn expression")
	   @ManagedOperationParameters({
	        @ManagedOperationParameter(name = "expression", description = "sets corn expression ")
	    })
	    
	public void setCornexpression(String cornexpression) {
		this.cornexpression = cornexpression;
	}
         
}