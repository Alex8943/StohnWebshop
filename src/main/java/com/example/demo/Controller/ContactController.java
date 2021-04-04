package com.example.demo.Controller;

import com.example.demo.Model.Contact;
import com.example.demo.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("kontakts", contactService.readAll());
        return "index";
    }
    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model) {
        model.addAttribute("kontakt", contactService.getKontakt(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Contact contact){
        contactService.update(contact);
        return "redirect:/";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Contact kontakt){
        contactService.create(kontakt);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        contactService.delete(id);
        return "redirect:/";
    }

}
