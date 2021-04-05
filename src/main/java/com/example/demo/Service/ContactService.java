package com.example.demo.Service;

import com.example.demo.Model.Contact;
import com.example.demo.Repoitory.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public void create(Contact contact){
        contactRepository.create(contact);
    }

    public void delete(long id){
        contactRepository.delete(id);
    }

    public Contact update(Contact kontakt){
        contactRepository.update(kontakt);
        return kontakt;
    }

    public List<Contact> readAll(){
        List<Contact> contacts = new ArrayList<>();
        for(Contact contact: contactRepository.readAll()){
            contacts.add(contact);
        }
        return contacts;
    }

    public Contact getKontakt(long id){
        return contactRepository.getContact(id);
    }
}
