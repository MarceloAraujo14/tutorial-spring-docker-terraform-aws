package com.maraujo.contactbook.service.client.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressResponse {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    @JsonProperty(namespace = "localidade")
    private String cidade;
    @JsonProperty(namespace = "uf")
    private String estado;
}
