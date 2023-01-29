package com.shop.webshop.service;

import com.shop.webshop.model.outter.ProductVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    public List<ProductVo> getProductList();

    public ResponseEntity<?> addProduct(ProductVo productVo, MultipartFile file) throws Exception;
}
