package com.ceyloncab.usermgtservice.domain.service.assembler.impl;

import com.ceyloncab.usermgtservice.domain.entity.ComplaintEntity;
import com.ceyloncab.usermgtservice.domain.entity.dto.response.complaint.ComplaintViewDto;
import com.ceyloncab.usermgtservice.domain.service.assembler.Assembler;
import org.springframework.stereotype.Service;

@Service
public class ViewComplaintAssembler implements Assembler<ComplaintEntity, ComplaintViewDto> {
    @Override
    public ComplaintEntity fromDto(ComplaintViewDto dto) {
        return null;
    }

    @Override
    public ComplaintViewDto toDto(ComplaintEntity model) {
        return new ComplaintViewDto(model.getSubject(),model.getDescription(),model.getUpdatedTime());
    }

    @Override
    public ComplaintViewDto toDto(ComplaintEntity model, Object object) {
        return null;
    }
}
