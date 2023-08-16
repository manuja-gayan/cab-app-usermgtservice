package com.ceyloncab.usermgtservice.domain.entity.dto.response.complaint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintViewDto {
    private String subject;
    private String description;
    private Date updatedDate;
}
