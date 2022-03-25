package com.harel.utils;

public enum ExceptionMsg {

    IDNUM_IS_NULL_OR_EMPTY(1, "idNum is null or empty"),
    IDNUM_ALREADY_EXISTS(2, "idNum already exists in DB"),
    PERSON_NOT_FOUND(3, "person not found");

    private Integer returnCode;
    private String returnDesc;

    ExceptionMsg(Integer returnCode, String returnDesc) {
        this.returnCode = returnCode;
        this.returnDesc = returnDesc;
    }

    public Integer getReturnCode() {
        return returnCode;
    }

    public String getReturnDesc() {
        return returnDesc;
    }
}
