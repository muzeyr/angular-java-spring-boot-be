package com.zcn.repository;

import com.zcn.entity.Category;
import com.zcn.entity.Musteri;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusteriRepository extends MongoRepository<Musteri, String> {

}
