package com.example.demo.controller;

import com.example.demo.payload.SmsRequest;
import com.example.demo.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {

    private final SmsService smsService;

    @Autowired
    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }
    // http://localhost:8080/send-sms
    @PostMapping("/send-sms")
    public String sendSms(@RequestBody SmsRequest smsRequest) {
        smsService.sendSms(smsRequest.getToPhoneNumber(), smsRequest.getMessage());
        return "SMS sent successfully";
    }
}

