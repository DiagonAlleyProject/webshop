package com.shop.webshop.model.outter;

import lombok.Data;

import java.io.InputStream;

@Data
public class ProductVo {
    private Integer idProduct;
    private String name;
    private String picture;
    private String description;
    private double price;
    private Long stock;
}
