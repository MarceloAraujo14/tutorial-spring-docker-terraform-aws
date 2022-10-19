package com.maraujo.contactbook.service;

import com.maraujo.contactbook.entity.Contact;
import com.maraujo.contactbook.repository.ContactbookRepository;
import com.maraujo.contactbook.service.client.ViaCepClient;
import com.maraujo.contactbook.service.client.response.AddressResponse;
import com.maraujo.contactbook.service.interfaces.ContactbookService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@AllArgsConstructor
public class ContactbookServiceImpl implements ContactbookService {

    private final ContactbookRepository repository;
    private final ViaCepClient viaCepClient;

    @Override
    public Contact save(Contact contact) {
        log.info("M save, contact={}, NEW", contact);
        try {
            AddressResponse address = viaCepClient.getAddress(contact.getCep());
            log.info("M getAddress, address={}", address);
            contact.setAddress(address);
            log.info("M save, contact={}, SAVING", contact);
            return repository.save(contact);
        }catch (Exception ex){
            log.info("Cannot find the address with cep={}, ERROR={}.", contact.getCep(), ex.getMessage());

            throw new IllegalArgumentException("Cannot find the address with cep: " + contact.getCep());
        }
    }

    @Override
    public List<Contact> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Contact> getByName(String name) {
        log.info("M getByName, name={}, NEW", name);
        return repository.findByName(name);
    }
}
