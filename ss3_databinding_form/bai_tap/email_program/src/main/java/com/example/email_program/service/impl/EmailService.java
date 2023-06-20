package com.example.email_program.service.impl;

import com.example.email_program.model.Email;
import com.example.email_program.repository.IEmailRepository;
import com.example.email_program.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private IEmailRepository emailRepository;

    @Override
    public List<String> getLanguage() {
        return emailRepository.getLanguages();
    }

    @Override
    public List<Integer> getSize() {
        return emailRepository.getSizes();
    }

    @Override
    public void editEmails(Email editEmail) {
        Email email = emailRepository.getEmail();
        email.setLanguage(editEmail.getLanguage());
        email.setSize(editEmail.getSize());
        email.setSpamFilter(editEmail.isSpamFilter());
        email.setSignature(editEmail.getSignature());
    }

    @Override
    public Email getEmail() {
        return emailRepository.getEmail();
    }
}
