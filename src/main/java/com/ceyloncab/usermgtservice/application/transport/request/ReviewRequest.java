package com.ceyloncab.usermgtservice.application.transport.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
    @NotNull( message = "Name not found for operation. This action is not allowed" )
    @Valid
    private String name;
    @NotNull( message = "Stars not found for operation. This action is not allowed" )
    @Valid
    private String stars;
    @NotNull( message = "Comment not found for operation. This action is not allowed" )
    @Valid
    private String comment;
}
