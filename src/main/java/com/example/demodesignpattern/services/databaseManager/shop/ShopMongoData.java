package com.example.demodesignpattern.services.databaseManager.shop;

import com.example.demodesignpattern.dtos.ShopDTO;
import com.example.demodesignpattern.entities.mongo.Shop;
import com.example.demodesignpattern.repositories.mongo.ShopMongoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Log4j2
public class ShopMongoData implements ShopFactory {
    @Autowired private ShopMongoRepository shopMongoRepository;

    @Override
    public ShopDTO getData(Integer shopId) throws Exception {
        try {
            Optional<Shop> shopData = shopMongoRepository.findById(shopId);
            if (shopData.isPresent()) {
                Shop shop = shopData.get();
                return ShopDTO.builder()
                        .id(shop.getId())
                        .name(shop.getName())
                        .build();
            }
        } catch (Exception e) {
            throw new Exception("Không tìm thấy Shop: " + shopId);
        }
        return null;
    }

    @Override
    public void createShop() throws Exception {
        log.info("Created shop Mongo");
    }

}
