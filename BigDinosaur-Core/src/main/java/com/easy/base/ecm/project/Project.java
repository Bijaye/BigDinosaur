package com.easy.base.ecm.project;

import java.util.List;

public interface Project extends EasyProject{
	Project	getProject();
	Project getProjectList();
	void setProjectList(List<Project> listproject);
	
	

}
