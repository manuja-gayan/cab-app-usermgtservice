package com.ceyloncab.usermgtservice.application.controller;

import com.ceyloncab.usermgtservice.application.transport.request.ReviewRequest;
import com.ceyloncab.usermgtservice.domain.entity.dto.response.CommonResponse;
import com.ceyloncab.usermgtservice.domain.service.ReviewManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("${base-url.context}/review")
public class ReviewController extends BaseController{
    @Autowired
    ReviewManagementService reviewManagementService;
    @PostMapping(value = "/getReview", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addReview(@Validated @RequestBody(required = true)ReviewRequest createRequest, HttpServletRequest request){
        CommonResponse<ReviewRequest> response = reviewManagementService.addReview(createRequest);
        return getResponseEntity(response.getResponseHeader().getResponseCode(),response);
    }

}
