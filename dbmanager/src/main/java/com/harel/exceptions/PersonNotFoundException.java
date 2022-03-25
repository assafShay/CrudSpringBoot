package com.harel.exceptions;

import com.harel.utils.ExceptionMsg;

public class PersonNotFoundException extends RuntimeException {

    private Integer returnCode;
    private String returnDesc;

    public Integer getReturnCode() {
        return returnCode;
    }

    public String getReturnDesc() {
        return returnDesc;
    }

    public PersonNotFoundException(ExceptionMsg em) {
        super(em.getReturnDesc());
        this.returnDesc = em.getReturnDesc();
        this.returnCode = em.getReturnCode();
    }
}
