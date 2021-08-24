package com.example.demodesignpattern.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShopDTO {
    private Integer id;
    private String name;
    private String phoneNumber;
}
