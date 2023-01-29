package com.shop.webshop.service;

import com.shop.webshop.Repository.ClientRepository;
import com.shop.webshop.model.inner.ClientDo;
import com.shop.webshop.model.outter.ClientVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
    public void addClient(ClientVo clientVo) {
        ClientDo clientDo = new ClientDo();
        BeanUtils.copyProperties(clientVo,clientDo);
        clientRepository.save(clientDo);
    }

}
