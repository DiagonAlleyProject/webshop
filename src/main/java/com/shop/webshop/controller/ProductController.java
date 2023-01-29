package com.shop.webshop.controller;

import com.shop.webshop.model.outter.ProductVo;
import com.shop.webshop.service.ProductService;
import com.shop.webshop.utils.NullUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/getAll")
    public ResponseEntity<?> getProductList (){
        Map<String,Object> response = new HashMap<>();
        List<ProductVo> productVoList = productService.getProductList();
        response.put("message","Operation completed successfully");
        response.put("response",productVoList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody MultipartFile file , ProductVo productVo) throws Exception {
        Map<String,Object> response = new HashMap<>();
        if (NullUtils.isEmpty(file)){
            response.put("Message","Image is empty");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return productService.addProduct(productVo, file);
    }

}

