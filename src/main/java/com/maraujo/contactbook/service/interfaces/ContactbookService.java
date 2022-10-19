package com.maraujo.contactbook.service.interfaces;

import com.maraujo.contactbook.entity.Contact;

import java.util.Optional;

public interface ContactbookService {
    Contact save(Contact contact);
    Optional<Contact> getByName(String name);
}
