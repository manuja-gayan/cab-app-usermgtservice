package com.ceyloncab.usermgtservice.domain.service;

import com.ceyloncab.usermgtservice.application.transport.request.ReviewRequest;
import com.ceyloncab.usermgtservice.domain.entity.ReviewEntity;
import com.ceyloncab.usermgtservice.domain.entity.dto.response.CommonResponse;
import com.ceyloncab.usermgtservice.domain.entity.dto.response.ResponseHeader;
import com.ceyloncab.usermgtservice.domain.service.assembler.impl.CreateReviewAssembler;
import com.ceyloncab.usermgtservice.domain.utils.Constants;
import com.ceyloncab.usermgtservice.external.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewManagementService {
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    CreateReviewAssembler createReviewAssembler;

    public CommonResponse<ReviewRequest> addReview(ReviewRequest request){
        CommonResponse<ReviewRequest> response=new CommonResponse<>();
        ReviewEntity document = createReviewAssembler.fromDto(request);
        try {
            document = reviewRepository.save(document);
        }catch (Exception ex){
            response.setResponseHeader(new ResponseHeader(Constants.ResponseData.COMMON_FAIL));
            return response;
        }
        response.setResponseHeader(new ResponseHeader(Constants.ResponseData.CREATE_SUCCESS));
        return response;
    }

}
