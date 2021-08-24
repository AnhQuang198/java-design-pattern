package com.example.demodesignpattern.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class ShopController extends BaseController{

    @GetMapping("/shops/{shopId}")
    public ResponseEntity<?> getShop(
            @PathVariable("shopId") Integer shopId
    ) {
        return shopService.getShopInfo(shopId);
    }

    @PostMapping("/shops")
    public ResponseEntity<?> createShop() {
        return shopService.createShop();
    }
}
