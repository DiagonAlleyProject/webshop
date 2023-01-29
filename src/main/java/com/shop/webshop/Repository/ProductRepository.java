package com.shop.webshop.Repository;

import com.shop.webshop.model.inner.ProductDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductDo, Long> {

}
