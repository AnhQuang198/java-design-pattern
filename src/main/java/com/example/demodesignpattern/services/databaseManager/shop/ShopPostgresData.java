package com.example.demodesignpattern.services.databaseManager.shop;

import com.example.demodesignpattern.dtos.ShopDTO;
import com.example.demodesignpattern.entities.Shop;
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
    public ShopDTO getData(Integer shopId) throws Exception {
        try {
            Optional<Shop> shopData = shopRepository.findById(shopId);
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
        log.info("Created shop Postgress");
    }

}
