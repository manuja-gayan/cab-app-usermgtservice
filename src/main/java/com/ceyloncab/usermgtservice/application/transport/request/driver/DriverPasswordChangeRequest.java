package com.ceyloncab.usermgtservice.application.transport.request.driver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverPasswordChangeRequest {
    @NotNull(message = "oldPassword not found for operation. This action is not allowed")
    @Valid
    private String oldPassword;
    @NotNull(message = "newPassword not found for operation. This action is not allowed")
    @Valid
    private String newPassword;
}
