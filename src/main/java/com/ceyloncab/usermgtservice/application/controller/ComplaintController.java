package com.ceyloncab.usermgtservice.application.controller;

import com.ceyloncab.usermgtservice.application.transport.request.ComplaintRequest;
import com.ceyloncab.usermgtservice.domain.entity.dto.response.CommonResponse;
import com.ceyloncab.usermgtservice.domain.service.ComplaintManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("${base-url.context}/complaint")
public class ComplaintController extends BaseController{
    @Autowired
    ComplaintManagementService complainMgmtService;

    @PostMapping(value = "/addComplaint", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createCustomerComplaint(@Validated @RequestBody(required = true) ComplaintRequest createRequest, HttpServletRequest request) throws Exception {

        CommonResponse<ComplaintRequest> response = complainMgmtService.createCustomerComplaint(createRequest);
        return getResponseEntity(response.getResponseHeader().getResponseCode(), response);
    }
    
    @GetMapping(value ="/getComplaint",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>getCustomerComplaint(HttpServletRequest request) throws Exception {

        CommonResponse response = complainMgmtService.getCustomerComplaint();
        return getResponseEntity(response.getResponseHeader().getResponseCode(),response);
    }
}
