package com.shop.webshop.model.outter;
import lombok.Data;

@Data
public class ClientVo {


    private int idClient;
    private String idCardNumber;
    private String name;
    private String lastName;
    private String address;
    private String email;
    private String password;
}
