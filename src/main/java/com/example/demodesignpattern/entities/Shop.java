package com.example.demodesignpattern.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "shops", name = "shop")
@Data
@NoArgsConstructor
public class Shop {
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;
}
