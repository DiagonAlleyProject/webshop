package com.shop.webshop.service;

import com.shop.webshop.model.outter.ProductVo;

import java.util.List;

public interface ProductService {
    public List<ProductVo> getProductList();

    public void addProduct(ProductVo productVo);
}
