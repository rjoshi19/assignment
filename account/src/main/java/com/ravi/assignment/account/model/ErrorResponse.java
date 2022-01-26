package com.ravi.assignment.account.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
@Setter
@Getter
public class ErrorResponse implements Serializable {

    private static final long serialVersionUID = -8125522525144033709L;

    private String errorCode;
    private String errorMsg;

    public ErrorResponse() {
    }

    public ErrorResponse(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
