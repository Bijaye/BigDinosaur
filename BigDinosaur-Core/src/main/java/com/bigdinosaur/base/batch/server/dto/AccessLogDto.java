package com.bigdinosaur.base.batch.server.dto;

public class AccessLogDto {

    public AccessLogDto() {
    }

    public String getPgmId() {
        return pgmId;
    }

    public void setPgmId(String pgmId) {
        this.pgmId = pgmId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    private String pgmId;
    private String fileType;
}
