package com.shop.webshop.model.inner;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="client")
public class ClientDo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_cliente")
    private Long idClient;
    @Column(name="id_card_number")
    private String idCardNumber;
    private String name;
    @Column(name="last_name")
    private String lastName;
    private String address;
    private String email;
    private String password;
}
