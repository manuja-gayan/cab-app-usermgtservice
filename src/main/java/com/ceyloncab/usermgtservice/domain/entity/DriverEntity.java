package com.ceyloncab.usermgtservice.domain.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document(collection = "Driver")
public class DriverEntity {
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private String licenceNumber;
    private String nicNumber;
    private String vehicleNumber;
    private String vehicleType;
    @Indexed(unique = true)
    private String msisdn;
    private String password;
    private String area;
    private String imgRefLicence;
    private String imgRefNic;
    private ArrayList<String> imgRefVehicleStatus;

}
