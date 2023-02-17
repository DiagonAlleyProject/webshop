package com.shop.webshop.controller;

import com.shop.webshop.model.inner.ChangePassword;
import com.shop.webshop.model.inner.ClientDo;
import com.shop.webshop.model.outter.ClientVo;
import com.shop.webshop.service.ClientService;
import com.shop.webshop.utils.NullUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @RequestMapping("/getAll")
    public ResponseEntity<?> getClientList() {
        Map<String, Object> response = new HashMap<>();
        List<ClientVo> clientListVo = clientService.getClientList();
        response.put("message", "Operation completed successfully");
        response.put("response", clientListVo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addClient(@Validated @RequestBody ClientDo clientDo) {
        return clientService.addClient(clientDo);
    }

    @PostMapping(value = "/changePassword")
    public ResponseEntity<?> changePassword(@RequestBody ChangePassword changePassword) {
        Map<String, Object> response = new HashMap<>();
        if (NullUtils.isNull(changePassword.getPassword())) {
            response.put("message", "Password must not be null");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        if (NullUtils.isNull(changePassword.getIdClient())) {
            response.put("message", "id must not be null");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        return clientService.changePassword(changePassword);
    }
}
