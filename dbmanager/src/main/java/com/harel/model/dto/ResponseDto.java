package com.harel.model.dto;

public class ResponseDto {

    private Integer returnCode;
    private String returnDesc;
    private Object responseObj;

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnDesc() {
        return returnDesc;
    }

    public void setReturnDesc(String returnDesc) {
        this.returnDesc = returnDesc;
    }

    public Object getResponseObj() {
        return responseObj;
    }

    public void setResponseObj(Object responseObj) {
        this.responseObj = responseObj;
    }

    public ResponseDto(Integer returnCode, String returnDesc, Object responseObj) {
        this.returnCode = returnCode;
        this.returnDesc = returnDesc;
        this.responseObj = responseObj;
    }
}
