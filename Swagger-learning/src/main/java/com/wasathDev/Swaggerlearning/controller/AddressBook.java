package com.wasathDev.Swaggerlearning.controller;

import com.wasathDev.Swaggerlearning.dto.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController

public class AddressBook {

    ConcurrentMap<String,Contact> map = new ConcurrentHashMap<>();

    @GetMapping("/{id}")
    public Contact getContact(@PathVariable String id){
        return map.get(id);
    }

    @GetMapping("/")
    public List<Contact>getAllContact(){
        return new ArrayList<Contact>(map.values());
    }

    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact){
        return map.put(contact.getId(), contact);
    }
}
