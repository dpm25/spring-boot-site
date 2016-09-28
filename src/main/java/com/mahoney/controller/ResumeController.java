package com.mahoney.controller;

import com.mahoney.model.ContactInfo;
import com.mahoney.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/resume")
public class ResumeController {

    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value = "/submit",method = {RequestMethod.POST}, consumes = {"application/json"})
    public ContactInfo submit(@RequestBody ContactInfo contactInfo) {
        return contactRepository.saveAndFlush(contactInfo);
    }
}
