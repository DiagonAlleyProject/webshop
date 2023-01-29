package com.shop.webshop.service;

import com.shop.webshop.Repository.ProductRepository;
import com.shop.webshop.model.inner.ProductDo;
import com.shop.webshop.model.outter.ProductVo;
import com.shop.webshop.utils.BeanUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<ProductVo> getProductList() {
        List<ProductDo> productDoList = productRepository.findAll();
        return BeanUtils.copyList(productDoList, ProductVo.class);
    }

    @Override
    public ResponseEntity<?> addProduct(ProductVo productVo, MultipartFile file) {
        ProductDo productDo = new ProductDo();
        Map<String,Object> response = new HashMap<>();
        Path pathName = Paths.get("src//main//resources/images");
        String absolutePath = pathName.toFile().getAbsolutePath();
        try {
            byte[] bitesImg = file.getBytes();
            Path finalPath = Paths.get(absolutePath + "//"+ file.getOriginalFilename());
            Files.write(finalPath,bitesImg);
            productVo.setPicture(file.getOriginalFilename());
        }catch (Exception e){
            response.put("message","Could not save the image");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        BeanUtils.copyProperties(productVo,productDo);
        productRepository.save(productDo);
        response.put("message","Product created successfully");
        response.put("response",productVo);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
