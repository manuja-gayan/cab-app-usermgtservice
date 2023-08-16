package com.ceyloncab.usermgtservice.domain.service.assembler.impl;

import com.ceyloncab.usermgtservice.application.transport.request.ComplaintRequest;
import com.ceyloncab.usermgtservice.domain.entity.ComplaintEntity;
import com.ceyloncab.usermgtservice.domain.service.assembler.Assembler;
import org.springframework.stereotype.Service;

@Service
public class CreateComplaintAssembler implements Assembler<ComplaintEntity, ComplaintRequest> {
    @Override
    public ComplaintEntity fromDto(ComplaintRequest dto) {
        ComplaintEntity model = new ComplaintEntity();
        model.setFirstName(dto.getFirstName());
        model.setLastName(dto.getLastName());
        model.setSubject(dto.getSubject());
        model.setMsisdn(dto.getMsisdn());
        model.setDescription(dto.getDescription());
        return model;
    }

    @Override
    public ComplaintRequest toDto(ComplaintEntity model) {
        return null;
    }

    @Override
    public ComplaintRequest toDto(ComplaintEntity model, Object object) {
        return null;
    }
}
