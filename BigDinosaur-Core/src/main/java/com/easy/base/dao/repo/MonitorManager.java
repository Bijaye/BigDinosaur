package com.easy.base.dao.repo;



import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;


@Entity
@SuppressWarnings("serial")
public class MonitorManager extends BaseJmx {


  

    @Column
    private String applicaitonid;

    @Column
    private String programid;

    @Column
    private String methodname;

    @Column
    private String servicename;

    @Column
    private String identity;

    @NotNull
    public Timestamp createdDate = null;
    
    @NotNull
    public String screenid = null;
    
    
  
    
    

   

    @PrePersist
    public void prePersist() throws Exception {
	Timestamp now = new Timestamp(new Date().getTime());

	setCreatedDate(now);

    }

   
   

    

    public String getProgramid() {
	return programid;
    }

    public void setProgramid(String programid) {
	this.programid = programid;
    }

    public String getMethodname() {
	return methodname;
    }

    public void setMethodname(String methodname) {
	this.methodname = methodname;
    }

    public String getServicename() {
	return servicename;
    }

    public void setServicename(String servicename) {
	this.servicename = servicename;
    }

    public String getIdentity() {
	return identity;
    }

    public void setIdentity(String identity) {
	this.identity = identity;
    }

    public Timestamp getCreatedDate() {
	return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
	this.createdDate = createdDate;
    }

    public String getScreenid() {
        return screenid;
    }

    public void setScreenid(String screenid) {
        this.screenid = screenid;
    }

	

	

}
