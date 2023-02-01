package com.shop.webshop.security;

import com.shop.webshop.Repository.ClientRepository;
import com.shop.webshop.model.inner.ClientDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ClientDo clientDo = clientRepository
                .findOneByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));

        return new UserDetailImpl(clientDo);
    }
}
