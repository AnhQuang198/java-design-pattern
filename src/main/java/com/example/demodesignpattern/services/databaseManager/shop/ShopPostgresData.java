package com.example.demodesignpattern.services.databaseManager.shop;

import com.example.demodesignpattern.dtos.ShopDTO;
import com.example.demodesignpattern.entities.Shop;
import com.example.demodesignpattern.exceptions.ResourceNotFoundException;
import com.example.demodesignpattern.repositories.ShopRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class ShopPostgresData implements ShopFactory {
    @Autowired private ShopRepository shopRepository;

    @Override
    public ShopDTO getData(Integer shopId) {
        try {
            Optional<Shop> shopData = shopRepository.findById(shopId);
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
        log.info("Created shop Postgres");
    }

}
