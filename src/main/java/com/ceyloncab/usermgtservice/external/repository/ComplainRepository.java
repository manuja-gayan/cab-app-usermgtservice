package com.ceyloncab.usermgtservice.external.repository;

import com.ceyloncab.usermgtservice.domain.entity.ComplaintEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplainRepository extends MongoRepository<ComplaintEntity,String> {

//    @Query(fields="{ subject : 1, description : 1}")
/*@Query(value = "select c.subject ,c.description from CustomerComplaint c")
    List<CustomerComplaintEntity> dataLoded();*/


}
