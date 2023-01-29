package com.shop.webshop.service;

import com.shop.webshop.model.outter.ClientVo;

import java.util.List;

public interface ClientService {

    public List<ClientVo> getClientList();

    public void addClient(ClientVo clientVo);
}
