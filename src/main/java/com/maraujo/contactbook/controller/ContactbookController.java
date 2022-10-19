package com.maraujo.contactbook.controller;

import com.maraujo.contactbook.controller.request.ContactRequest;
import com.maraujo.contactbook.service.interfaces.ContactbookService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/contact")
public class ContactbookController {

    @Autowired
    private ContactbookService contactbookService;

    @PostMapping
    public ResponseEntity save(@RequestBody ContactRequest request){
        log.info("M save, request={}", request);
        return ResponseEntity.ok(contactbookService.save(request.toEntity()));
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity getByName(@PathVariable("name") String name){
        log.info("M getByName, name={}", name);
        return ResponseEntity.ok(contactbookService.getByName(name));
    }

    @GetMapping
    public ResponseEntity getAll(){
        log.info("M getAll, NEW");
        return ResponseEntity.ok(contactbookService.getAll());
    }
}
