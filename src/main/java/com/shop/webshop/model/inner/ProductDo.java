package com.shop.webshop.model.inner;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="product")
public class ProductDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_product")
    private Integer idProduct;
    private String name;
    private String picture;
    private String description;
    private double price;
    private Long stock;

}
