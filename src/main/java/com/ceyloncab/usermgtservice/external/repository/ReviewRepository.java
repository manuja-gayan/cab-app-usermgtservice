package com.ceyloncab.usermgtservice.external.repository;

import com.ceyloncab.usermgtservice.domain.entity.ReviewEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<ReviewEntity,String> {
}
