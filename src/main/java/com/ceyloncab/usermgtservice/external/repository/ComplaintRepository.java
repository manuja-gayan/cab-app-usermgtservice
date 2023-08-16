package com.ceyloncab.usermgtservice.external.repository;

import com.ceyloncab.usermgtservice.domain.entity.ComplaintEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends MongoRepository<ComplaintEntity,String> {
}
