package com.shop.webshop.controller;

import com.shop.webshop.model.inner.ClientDo;
import com.shop.webshop.model.outter.ClientVo;
import com.shop.webshop.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @RequestMapping("/getAll")
    public ResponseEntity<?> getClientList (){
        Map<String,Object> response = new HashMap<>();
        List<ClientVo> clientListVo = clientService.getClientList();
        response.put("message","Operation completed successfully");
        response.put("response",clientListVo);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PostMapping(value = "/add")
    public ResponseEntity<?> addClient(@Validated @RequestBody ClientDo clientDo){
        return clientService.addClient(clientDo);
    }

}
