package com.zcn.repository;

import com.zcn.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusteriRepository extends MongoRepository<Customer, String> {

}
