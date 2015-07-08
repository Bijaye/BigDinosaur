package com.base.easy.program;



public class Program {

    private String programId;

    private String programName;

  
    public Program() {

    }

    public Program(String programId, String programName) {
        this.programId = programId;
        this.programName = programName;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

 
    public String getProgramName() {
        return programName;
    }
}
