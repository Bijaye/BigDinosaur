
package com.bigdinosaur.base.model;

import java.io.Serializable;
import java.util.List;

public class BatchLogContext implements Serializable {


    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String programID;

    private String batchPGMID;

    private String operationType;

    private String errorDB;

    private String errorType;

    private String errorDescription;

    private Boolean errorExists;

    private List<BatchDBSearchDto> dtoList;

    public String getOperationType() {
        return operationType;
    }
    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
    public void setProgramID(String programID) {
        this.programID = programID;
    }

    public String getProgramID() {
        return programID;
    }

    public String getErrorDB() {
        return errorDB;
    }
    public void setErrorDB(String errorDB) {
        this.errorDB = errorDB;
    }

    public String getErrorType() {
        return errorType;
    }
    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public void setBatchPGMID(String batchPGMID) {
        this.batchPGMID = batchPGMID;
    }

    public String getBatchPGMID() {
        return batchPGMID;
    }

    public void setIsErrorExists(Boolean isErrorExists) {
        this.errorExists = isErrorExists;
    }
    public Boolean getIsErrorExists() {
        return errorExists;
    }

    public void setDtoList(List<BatchDBSearchDto> dtoList) {
        this.dtoList = dtoList;
    }
    public List<BatchDBSearchDto> getDtoList() {
        return dtoList;
    }

}
