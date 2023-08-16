package com.ceyloncab.usermgtservice.domain.service;

import com.ceyloncab.usermgtservice.application.transport.request.driver.DriverPasswordChangeRequest;
import com.ceyloncab.usermgtservice.application.transport.request.driver.DriverPasswordVerify;
import com.ceyloncab.usermgtservice.application.transport.request.driver.DriverRequest;
import com.ceyloncab.usermgtservice.domain.entity.DriverEntity;
import com.ceyloncab.usermgtservice.domain.entity.dto.response.CommonResponse;
import com.ceyloncab.usermgtservice.domain.entity.dto.response.ResponseHeader;
import com.ceyloncab.usermgtservice.domain.exception.DomainException;
import com.ceyloncab.usermgtservice.domain.service.assembler.impl.CreateDriverAssembler;
import com.ceyloncab.usermgtservice.domain.utils.Constants;
import com.ceyloncab.usermgtservice.external.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverManagementService {
    @Autowired
    CreateDriverAssembler driverAssembler;

    @Autowired
    DriverRepository driverRepository;

    public CommonResponse<DriverRequest> createDriverProfile(DriverRequest request) {
        CommonResponse<DriverRequest> response = new CommonResponse<>();

        DriverEntity document = driverAssembler.fromDto(request);
        try {
            document = driverRepository.save(document);
        } catch (Exception e) {
            response.setResponseHeader(new ResponseHeader(Constants.ResponseData.COMMON_FAIL));
            return response;
        }

        response.setData(driverAssembler.toDto(document));
        response.setResponseHeader(new ResponseHeader(Constants.ResponseData.CREATE_SUCCESS));

        return response;
    }

    public CommonResponse<DriverRequest> verifyPassword(DriverPasswordVerify passwordVerify) {
        CommonResponse<DriverRequest> response = new CommonResponse<>();
        Optional<DriverEntity> driver = driverRepository.findOneByMsisdn(passwordVerify.getMsisdn());
        if(Boolean.FALSE.equals(driver.isPresent())){
            throw new DomainException(Constants.ResponseData.DRIVER_NOT_FOUND);
        } else if (isPasswordValid(passwordVerify.getPassword(), driver.get())) {
            response.setData(driverAssembler.toDto(driver.get(), "PASSWORD_VERIFY"));
            response.setResponseHeader(new ResponseHeader(Constants.ResponseData.VERIFY_SUCCESS));
        } else {
            throw new DomainException(Constants.ResponseData.PASSWORD_NOT_MATCHED);
        }
        return response;
    }

    public CommonResponse updateDriverPassword(DriverPasswordChangeRequest driverPasswordChangeRequest, String userID) {
        CommonResponse<Object> response = new CommonResponse<>();

        try {
            DriverEntity driverEntity = driverRepository.findById(userID).get();
            driverEntity.setPassword(driverPasswordChangeRequest.getNewPassword());
            driverRepository.save(driverEntity);
        } catch (Exception e) {
            response.setResponseHeader(new ResponseHeader(Constants.ResponseData.COMMON_FAIL));
            return response;
        }
        response.setResponseHeader(new ResponseHeader(Constants.ResponseData.CREATE_SUCCESS));

        return response;
    }
    private Boolean isPasswordValid(String password, DriverEntity driverEntity){
        return driverEntity.getPassword().equals(password);
    }
}
