package com.mahoney.controller;

import com.mahoney.model.ContactInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/resume")
public class ResumeController {

    @RequestMapping(value = "/submit",method = {RequestMethod.POST, RequestMethod.GET})
    public ContactInfo submit(@RequestBody ContactInfo contactInfo) {
        System.out.print(contactInfo.toString());
        return contactInfo;
    }
}
