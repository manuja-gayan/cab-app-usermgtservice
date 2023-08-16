package com.ceyloncab.usermgtservice.external.exception;

import com.ceyloncab.usermgtservice.domain.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExternalException extends RuntimeException{
    private String code;
    private String message;
    private String responseCode = "400";

    public ExternalException(Constants.ResponseData response){
        this.code=response.getCode();
        this.message=response.getMessage();
        this.responseCode=response.getResponseCode();
    }
}
