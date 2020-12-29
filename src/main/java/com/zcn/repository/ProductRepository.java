package com.zcn.repository;

import com.zcn.entity.Category;
import com.zcn.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
