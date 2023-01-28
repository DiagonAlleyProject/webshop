package com.shop.webshop.controller;

import com.shop.webshop.model.outter.ProductVo;
import com.shop.webshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/getAll")
    public ResponseEntity<List<ProductVo>> getProductList (){
        List<ProductVo> productListVo = productService.getProductList();
        return new ResponseEntity<>(productListVo, HttpStatus.OK);
    }

    @PostMapping(value = "/addProduct")
    public ResponseEntity<ProductVo> addProduct(@Validated @RequestBody ProductVo productVo){
        productService.addProduct(productVo);
        return new ResponseEntity<>(productVo,null, HttpStatus.CREATED);
    }

}

