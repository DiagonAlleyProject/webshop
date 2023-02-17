package com.shop.webshop.service;

import com.shop.webshop.Repository.ClientRepository;
import com.shop.webshop.model.inner.ChangePassword;
import com.shop.webshop.model.inner.ClientDo;
import com.shop.webshop.model.outter.ClientVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        clientDo.setPassword(new BCryptPasswordEncoder().encode(clientDo.getPassword()));
        clientRepository.save(clientDo);
        BeanUtils.copyProperties(clientDo,clientVo);
        response.put("message","Client created successfully");
        response.put("response",clientVo);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @Override
    public ResponseEntity<?> changePassword(ChangePassword changePassword){
        Map<String,Object> response = new HashMap<>();
        ClientDo clientDo;
        clientDo = clientRepository.findById(changePassword.getIdClient())
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
        clientDo.setPassword(new BCryptPasswordEncoder().encode(changePassword.getPassword()));
        clientRepository.save(clientDo);
        response.put("message","New password changed succesfully");
        response.put("response", clientDo.getName() + " " + clientDo.getLastName());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
