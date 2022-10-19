package com.maraujo.contactbook.entity;

import com.maraujo.contactbook.service.client.response.AddressResponse;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "contact")
@Table(name = "contact_book_tb")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phone;
    private String cep;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    public void setAddress(AddressResponse address){
        this.logradouro = address.getLogradouro();
        this.bairro = address.getBairro();
        this.complemento = address.getComplemento();
        this.cidade = address.getCidade();
        this.estado = address.getEstado();
    }


}
