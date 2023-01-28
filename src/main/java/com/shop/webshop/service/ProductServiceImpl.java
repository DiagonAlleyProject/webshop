package com.shop.webshop.service;

import com.shop.webshop.Repository.ProductRepository;
import com.shop.webshop.model.inner.ProductDo;
import com.shop.webshop.model.outter.ProductVo;
import com.shop.webshop.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public void addProduct(ProductVo productVo) {
        ProductDo productDo = new ProductDo();
        BeanUtils.copyProperties(productVo,productDo);
        productRepository.save(productDo);
    }
}
