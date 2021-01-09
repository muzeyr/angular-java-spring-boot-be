package com.zcn.repository;

import com.zcn.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {



    @Query(value = "from Order t where t.createdAt BETWEEN :startDate AND :endDate")
    public List<Order> getAllBetweenDates(@Param("createdAt") LocalDateTime startDate, @Param("endDate")LocalDateTime endDate);


}
