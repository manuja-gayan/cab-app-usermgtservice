package com.ceyloncab.usermgtservice.domain.service.assembler.impl;

import com.ceyloncab.usermgtservice.application.transport.request.driver.DriverRequest;
import com.ceyloncab.usermgtservice.domain.entity.DriverEntity;
import com.ceyloncab.usermgtservice.domain.service.assembler.Assembler;
import org.springframework.stereotype.Service;

@Service
public class CreateDriverAssembler implements Assembler<DriverEntity, DriverRequest> {

    @Override
    public DriverEntity fromDto(DriverRequest dto) {
        DriverEntity driverEntity = new DriverEntity();
        driverEntity.setFirstName(dto.getFirstName());
        driverEntity.setLastName(dto.getLastName());
        driverEntity.setLicenceNumber(dto.getLicenceNumber());
        driverEntity.setNicNumber(dto.getNicNumber());
        driverEntity.setVehicleNumber(dto.getVehicleNumber());
        driverEntity.setVehicleType(dto.getVehicleType());
        driverEntity.setMsisdn(dto.getMsisdn());
        driverEntity.setPassword(dto.getPassword());
        driverEntity.setArea(dto.getArea());
        driverEntity.setImgRefLicence(dto.getImgRefLicence());
        driverEntity.setImgRefNic(dto.getImgRefNic());
        driverEntity.setImgRefVehicleStatus(dto.getImgRefVehicleStatus());

        return driverEntity;
    }

    @Override
    public DriverRequest toDto(DriverEntity model) {
        return new DriverRequest(
                model.getUserId(),
                model.getFirstName(),
                model.getLastName(),
                model.getLicenceNumber(),
                model.getNicNumber(),
                model.getVehicleNumber(),
                model.getVehicleType(),
                model.getMsisdn(),
                model.getPassword(),
                model.getArea(),
                model.getImgRefLicence(),
                model.getImgRefNic(),
                model.getImgRefVehicleStatus()
        );
    }

    @Override
    public DriverRequest toDto(DriverEntity model, Object object) {
        DriverRequest driverRequest = new DriverRequest();
        String type = (String) object;
        switch (type){
            case "PASSWORD_VERIFY":
                return passwordVerify(model);
            case "DRIVER_CREATE":
            default:
                return driverCreate(model);
        }
    }

    private DriverRequest driverCreate(DriverEntity model){
        return new DriverRequest(
                model.getUserId(),
                model.getFirstName(),
                model.getLastName(),
                model.getLicenceNumber(),
                model.getNicNumber(),
                model.getVehicleNumber(),
                model.getVehicleType(),
                model.getMsisdn(),
                model.getPassword(),
                model.getArea(),
                model.getImgRefLicence(),
                model.getImgRefNic(),
                model.getImgRefVehicleStatus()
        );
    }

    private DriverRequest passwordVerify(DriverEntity model){
        DriverRequest driverRequest = new DriverRequest();
        driverRequest.setUserId(model.getUserId());
        driverRequest.setFirstName(model.getFirstName());
        driverRequest.setLastName(model.getLastName());
        driverRequest.setMsisdn(model.getMsisdn());
        return driverRequest;
    }
}
