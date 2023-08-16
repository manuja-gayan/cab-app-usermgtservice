package com.ceyloncab.usermgtservice.application.controller;

import com.ceyloncab.usermgtservice.application.transport.request.driver.DriverPasswordChangeRequest;
import com.ceyloncab.usermgtservice.application.transport.request.driver.DriverPasswordVerify;
import com.ceyloncab.usermgtservice.application.transport.request.driver.DriverRequest;
import com.ceyloncab.usermgtservice.domain.entity.dto.response.CommonResponse;
import com.ceyloncab.usermgtservice.domain.service.DriverManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "${base-url.context}/driver")
public class DriverController extends BaseController {
    @Autowired
    DriverManagementService driverManagementService;

    @PostMapping(value = "/profile/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createDriverProfile(@Validated @RequestBody(required = true) DriverRequest createRequest, HttpServletRequest request) {
        CommonResponse<DriverRequest> response = driverManagementService.createDriverProfile(createRequest);
        return getResponseEntity(response.getResponseHeader().getResponseCode(), response);
    }

    @PostMapping(value = "/verify/password", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> verifyPassword(@Validated @RequestBody(required = true) DriverPasswordVerify driverPasswordVerify, HttpServletRequest request) {
        CommonResponse<DriverRequest> response = driverManagementService.verifyPassword(driverPasswordVerify);
        return getResponseEntity(response.getResponseHeader().getResponseCode(), response);
    }

    @PutMapping(value = "/changePassword", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateDriverPassword(@Validated @RequestBody DriverPasswordChangeRequest driverPasswordChangeRequest, HttpServletRequest request) {

        CommonResponse response = driverManagementService.updateDriverPassword(driverPasswordChangeRequest, request.getHeader("UserId"));
        return getResponseEntity(response.getResponseHeader().getResponseCode(), response);
    }
}
