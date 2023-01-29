package com.shop.webshop.Repository;

import com.shop.webshop.model.inner.ClientDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientDo,Long > {

}
