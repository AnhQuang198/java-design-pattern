package com.example.demodesignpattern.repositories;

import com.example.demodesignpattern.entities.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
}
