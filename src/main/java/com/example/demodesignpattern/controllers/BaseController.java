package com.example.demodesignpattern.controllers;

import com.example.demodesignpattern.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    @Autowired protected ShopService shopService;
}
