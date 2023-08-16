package com.ceyloncab.usermgtservice.application.transport.request.driver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverPasswordVerify {
    @NotNull( message = "password not found for operation. This action is not allowed" )
    @Valid
    private String password;
    @NotNull( message = "msisdn not found for operation. This action is not allowed" )
    @Valid
    private String msisdn;
}
