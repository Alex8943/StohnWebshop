package com.example.demo.Controller;

import com.example.demo.Model.Contact;
import com.example.demo.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class Restcontroller {
    @Autowired
    ContactService contactService;

    @GetMapping("/contacts")
    public List<Contact> contact() {
        return contactService.readAll();
    }

    @PostMapping("/contacts")
    public ResponseEntity<Contact> createContacts(@RequestBody Contact contact) {
        Contact newKontakt = new Contact(contact.getKontaktID(), contact.getFornavn(), contact.getEfternavn(), contact.getAdresse(), contact.getHusNr(), contact.getTlfnumb());
        contactService.create(newKontakt);

        HttpHeaders headers = new HttpHeaders();
        headers.add("location", "/products/" + contact.getKontaktID());
        return new ResponseEntity<>(newKontakt, headers, HttpStatus.CREATED);
    }

    @GetMapping("/contacts/{id}")
    public Contact getContactByID(@PathVariable("id") int id) {
        return contactService.getKontakt(id);
    }

    @DeleteMapping("/contacts/{id}")
    public void deleteContactByID(@PathVariable("id") int id) {
        contactService.delete(id);
    }

    @PutMapping("/contact/{id}")
    public ResponseEntity<Contact> contactUpdate(@PathVariable("id") int id, @RequestBody Contact kontaktDetails) {
        Contact contact = contactService.getKontakt(id);

        contact.setKontaktID(kontaktDetails.getKontaktID());
        contact.setFornavn(kontaktDetails.getFornavn());
        contact.setEfternavn(kontaktDetails.getEfternavn());
        contact.setAdresse(kontaktDetails.getAdresse());
        contact.setHusNr(kontaktDetails.getHusNr());
        contact.setTlfnumb(kontaktDetails.getTlfnumb());

        final Contact updatedKontakt = contactService.update(contact);

        return ResponseEntity.ok(updatedKontakt);
    }

}
