package com.zcn.repository;

import com.zcn.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SiparisRepository extends MongoRepository<Order, String> {

}
