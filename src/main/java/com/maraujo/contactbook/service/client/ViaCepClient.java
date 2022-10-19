package com.maraujo.contactbook.service.client;

import com.maraujo.contactbook.service.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "viaCep", url = "${viacep.endpoint}")
public interface ViaCepClient {

    @GetMapping(value = "/{cep}/json")
    AddressResponse getAddress(@PathVariable(value = "cep") String cep);
}
