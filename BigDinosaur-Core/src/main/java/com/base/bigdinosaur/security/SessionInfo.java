package com.base.bigdinosaur.security;

public interface SessionInfo {
	Object getGroupInfo();
	Object getSubRoleInfo();
	Object getRoleInfo();
	Object getSubGroupInfo();
	Object getTeamInfo();
	Object getSubTeamInfo();
	Object getUserInfo();
	Object getWorkstationInfo();

}
