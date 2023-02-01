package com.shop.webshop.Repository;

import com.shop.webshop.model.inner.ClientDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientDo,Long > {

    Optional<ClientDo> findOneByEmail(String email);

}
