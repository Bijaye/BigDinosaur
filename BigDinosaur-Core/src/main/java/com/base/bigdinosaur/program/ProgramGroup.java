package com.base.bigdinosaur.program;

import java.util.ArrayList;
import java.util.List;

public class ProgramGroup {

	private String title;

	private List<Program> programs = new ArrayList<Program>();

	private String groupId;

	public ProgramGroup(String title) {
		this.title = title;
	}

	public ProgramGroup(String title, Program... programs) {
		this(title);
		for (Program s : programs) {
			this.programs.add(s);
		}
	}

	public String getTitle() {
		return title;
	}

	public void addProgram(Program function) {
		programs.add(function);
	}

	public List<Program> getPrograms() {
		return programs;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupId() {
		return groupId;
	}
}
