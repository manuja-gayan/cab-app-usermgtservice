package com.ceyloncab.usermgtservice.domain.service.assembler.impl;

import com.ceyloncab.usermgtservice.application.transport.request.ReviewRequest;
import com.ceyloncab.usermgtservice.domain.entity.ReviewEntity;
import com.ceyloncab.usermgtservice.domain.service.assembler.Assembler;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CreateReviewAssembler implements Assembler<ReviewEntity, ReviewRequest> {
    @Override
    public ReviewEntity fromDto(ReviewRequest dto) {
        ReviewEntity model=new ReviewEntity();
        model.setName(dto.getName());
        model.setStars(dto.getStars());
        model.setComment(dto.getComment());
        return model;
    }

    @Override
    public ReviewRequest toDto(ReviewEntity model) {
        return new ReviewRequest(model.getName(), model.getStars(), model.getComment());
    }

    @Override
    public ReviewRequest toDto(ReviewEntity model, Object object) {
        return null;
    }
}
