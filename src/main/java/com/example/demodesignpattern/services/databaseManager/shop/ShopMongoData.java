package com.example.demodesignpattern.services.databaseManager.shop;

import com.example.demodesignpattern.dtos.ShopDTO;
import com.example.demodesignpattern.entities.mongo.Shop;
import com.example.demodesignpattern.exceptions.ResourceNotFoundException;
import com.example.demodesignpattern.repositories.mongo.ShopMongoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Log4j2
public class ShopMongoData implements ShopFactory {
    @Autowired
    private ShopMongoRepository shopMongoRepository;

    @Override
    public ShopDTO getData(Integer shopId) {
        try {
            Optional<Shop> shopData = shopMongoRepository.findById(shopId);
            Shop shop = shopData.get();
            return ShopDTO.builder()
                    .id(shop.getId())
                    .name(shop.getName())
                    .phoneNumber(shop.getPhone())
                    .build();
        } catch (Exception e) {
            throw new ResourceNotFoundException("Không tìm thấy Shop: " + shopId);
        }
    }

    @Override
    public void createShop() {
        log.info("Created shop Mongo");
    }

}
