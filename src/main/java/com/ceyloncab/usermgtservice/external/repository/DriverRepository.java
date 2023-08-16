package com.ceyloncab.usermgtservice.external.repository;

import com.ceyloncab.usermgtservice.domain.entity.DriverEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DriverRepository extends MongoRepository<DriverEntity, String> {
    Optional<DriverEntity> findOneByMsisdn(String msisdn);
}
