package com.shop.webshop.controller;

import com.shop.webshop.model.outter.ClientVo;
import com.shop.webshop.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @RequestMapping("/getAll")
    public ResponseEntity<List<ClientVo>> getClientList (){
        List<ClientVo> clientListVo = clientService.getClientList();
        return new ResponseEntity<>(clientListVo,HttpStatus.OK);
    }
    @PostMapping(value = "/add")
    public ResponseEntity<ClientVo> addClient(@Validated @RequestBody ClientVo clientVo){
        clientService.addClient(clientVo);
        return new ResponseEntity<>(clientVo,null, HttpStatus.CREATED);
    }

}
