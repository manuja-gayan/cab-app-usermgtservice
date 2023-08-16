package com.ceyloncab.usermgtservice.application.transport.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintRequest {
    private String complaintId;
    @NotNull(message = "firstName not found for operation. This action is not allowed")
    @Valid
    private String firstName;
    @NotNull(message = "lastName not found for operation. This action is not allowed")
    @Valid
    private String lastName;
    @NotNull(message = "subject not found for operation. This action is not allowed")
    @Valid
    private String subject;
    @NotNull(message = "msisdn not found for operation. This action is not allowed")
    @Valid
    private String msisdn;
    @NotNull(message = "description not found for operation. This action is not allowed")
    @Valid
    private String description;
}
