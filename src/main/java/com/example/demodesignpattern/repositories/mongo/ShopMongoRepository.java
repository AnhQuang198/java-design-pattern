package com.example.demodesignpattern.repositories.mongo;

import com.example.demodesignpattern.entities.mongo.Shop;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShopMongoRepository extends MongoRepository<Shop, Integer> {
}
