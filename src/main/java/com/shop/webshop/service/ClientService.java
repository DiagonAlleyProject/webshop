package com.shop.webshop.service;

import com.shop.webshop.model.inner.ClientDo;
import com.shop.webshop.model.outter.ClientVo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientService {

    public List<ClientVo> getClientList();

    public ResponseEntity<?> addClient(ClientDo clientDo);
}
