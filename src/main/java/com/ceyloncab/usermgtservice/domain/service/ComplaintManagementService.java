package com.ceyloncab.usermgtservice.domain.service;

import com.ceyloncab.usermgtservice.application.aop.AopConstants;
import com.ceyloncab.usermgtservice.application.transport.request.ComplaintRequest;
import com.ceyloncab.usermgtservice.domain.entity.ComplaintEntity;
import com.ceyloncab.usermgtservice.domain.entity.CustomerEntity;
import com.ceyloncab.usermgtservice.domain.entity.dto.response.CommonResponse;
import com.ceyloncab.usermgtservice.domain.entity.dto.response.ResponseHeader;
import com.ceyloncab.usermgtservice.domain.entity.dto.response.complaint.ComplaintViewDto;
import com.ceyloncab.usermgtservice.domain.exception.DomainException;
import com.ceyloncab.usermgtservice.domain.service.assembler.impl.CreateComplaintAssembler;
import com.ceyloncab.usermgtservice.domain.service.assembler.impl.ViewComplaintAssembler;
import com.ceyloncab.usermgtservice.domain.utils.Constants;
import com.ceyloncab.usermgtservice.external.repository.ComplaintRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import com.ceyloncab.usermgtservice.external.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ComplaintManagementService {
    @Autowired
    ComplaintRepository complaintRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    CreateComplaintAssembler createComplaintAssembler;

    @Autowired
    private ViewComplaintAssembler viewComplaintAssembler;

    public CommonResponse<ComplaintRequest> createCustomerComplaint(ComplaintRequest request) {
        CommonResponse<ComplaintRequest> response = new CommonResponse<>();

        CustomerEntity customer = customerRepository.findById(MDC.get(AopConstants.MDC_USERID))
                .orElseThrow(() -> {
            log.error("Customer does not exist for given userId:{}", MDC.get(AopConstants.MDC_USERID));
            return new DomainException(Constants.ResponseData.CUSTOMER_NOT_FOUND);
        });
        ComplaintEntity document = createComplaintAssembler.fromDto(request);
        document.setCustomer(customer);

        try {
            complaintRepository.save(document);
        } catch (Exception e) {
            response.setResponseHeader(new ResponseHeader(Constants.ResponseData.COMMON_FAIL));
            return response;
        }
        response.setResponseHeader(new ResponseHeader(Constants.ResponseData.CREATE_SUCCESS));
        return response;
    }

    public CommonResponse<List<ComplaintViewDto>> getCustomerComplaint() {
        CommonResponse<List<ComplaintViewDto>> response = new CommonResponse<>();
        List<ComplaintViewDto> complaintRequestList = new ArrayList<>();
        CustomerEntity customer = customerRepository.findById(MDC.get(AopConstants.MDC_USERID))
                .orElseThrow(() -> {
                    log.error("Customer does not exist for given userId:{}", MDC.get(AopConstants.MDC_USERID));
                    return new DomainException(Constants.ResponseData.CUSTOMER_NOT_FOUND);
                });
        List<ComplaintEntity> complaintEntities = customer.getComplaintEntityList();
        for (ComplaintEntity complaintEntity : complaintEntities) {
            complaintRequestList.add(viewComplaintAssembler.toDto(complaintEntity));
        }
        response.setData(complaintRequestList);
        response.setResponseHeader(new ResponseHeader(Constants.ResponseData.QUERY_SUCCESS));
        return response;
    }
}
