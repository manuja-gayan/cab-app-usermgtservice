package com.ceyloncab.usermgtservice.application.transport.request.driver;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DriverRequest {
    private String userId;
    @NotNull( message = "firstName not found for operation. This action is not allowed" )
    @Valid
    private String firstName;
    @NotNull( message = "lastName not found for operation. This action is not allowed" )
    @Valid
    private String lastName;
    @NotNull( message = "licenceNumber not found for operation. This action is not allowed" )
    @Valid
    private String licenceNumber;
    @NotNull( message = "nicNumber not found for operation. This action is not allowed" )
    @Valid
    private String nicNumber;
    @NotNull( message = "vehicleNumber not found for operation. This action is not allowed" )
    @Valid
    private String vehicleNumber;
    @NotNull( message = "vehicleType not found for operation. This action is not allowed" )
    @Valid
    private String vehicleType;
    @NotNull( message = "msisdn not found for operation. This action is not allowed" )
    @Valid
    private String msisdn;
    @NotNull( message = "password not found for operation. This action is not allowed" )
    @Valid
    private String password;
    @NotNull( message = "area not found for operation. This action is not allowed" )
    @Valid
    private String area;
    @NotNull( message = "imgRefLicence not found for operation. This action is not allowed" )
    @Valid
    private String imgRefLicence;
    @NotNull( message = "imgRefNic not found for operation. This action is not allowed" )
    @Valid
    private String imgRefNic;
    private ArrayList<String> imgRefVehicleStatus;
}
