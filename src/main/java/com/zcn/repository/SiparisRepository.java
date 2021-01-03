package com.zcn.repository;

import com.zcn.entity.Category;
import com.zcn.entity.Siparis;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SiparisRepository extends MongoRepository<Siparis, String> {

}
