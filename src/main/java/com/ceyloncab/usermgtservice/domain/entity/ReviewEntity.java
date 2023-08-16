package com.ceyloncab.usermgtservice.domain.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Review")
public class ReviewEntity {
    private String name;
    private String stars;
    private String comment;
}
