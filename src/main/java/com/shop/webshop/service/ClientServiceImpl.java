package com.shop.webshop.service;

import ch.qos.logback.core.net.server.ClientVisitor;
import com.shop.webshop.Repository.ClientRepository;
import com.shop.webshop.model.inner.ClientDo;
import com.shop.webshop.model.outter.ClientVo;
import com.shop.webshop.utils.SensitiveUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    ClientRepository clientRepository;
    @Override
    public List<ClientVo> getClientList() {
        List<ClientDo> clientListDo;
        clientListDo = clientRepository.findAll();
        return com.shop.webshop.utils.BeanUtils.copyList(clientListDo,ClientVo.class);
    }

    @Override
    public ResponseEntity<?> addClient(ClientDo clientDo) {
        Map<String,Object> response = new HashMap<>();
        ClientVo clientVo = new ClientVo();
        clientDo.setPassword(SensitiveUtils.encrypt(clientDo.getPassword()));
        clientRepository.save(clientDo);
        BeanUtils.copyProperties(clientDo,clientVo);
        response.put("message","Client created successfully");
        response.put("response",clientVo);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

}
