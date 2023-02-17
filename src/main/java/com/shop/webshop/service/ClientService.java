package com.shop.webshop.service;

import com.shop.webshop.model.inner.ChangePassword;
import com.shop.webshop.model.inner.ClientDo;
import com.shop.webshop.model.outter.ClientVo;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface ClientService {

    List<ClientVo> getClientList();

    ResponseEntity<?> addClient(ClientDo clientDo);

    ResponseEntity<?> changePassword(ChangePassword changePassword);

}
