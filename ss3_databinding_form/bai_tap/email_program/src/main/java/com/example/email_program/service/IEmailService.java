package com.example.email_program.service;

import com.example.email_program.model.Email;

import java.util.List;

public interface IEmailService {
    List<String> getLanguage();

    List<Integer> getSize();

    void editEmails(Email email);

    Email getEmail();
}
