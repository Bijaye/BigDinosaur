package com.bigdinosaur.batch.extend.model;


public class BatchDBSearchDto {


    private String pgmId;

    private String callerPGMID;

    private String searchDB;

    private String operationType;

    public String getPgmId() {
        return pgmId;
    }

    public void setPgmId(String pgmId) {
        this.pgmId = pgmId;
    }

    public String getCallerPGMID() {
        return callerPGMID;
    }

    public void setCallerPGMID(String callerPGMID) {
        this.callerPGMID = callerPGMID;
    }

    public String getSearchDB() {
        return searchDB;
    }

    public void setSearchDB(String searchDB) {
        this.searchDB = searchDB;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

}
