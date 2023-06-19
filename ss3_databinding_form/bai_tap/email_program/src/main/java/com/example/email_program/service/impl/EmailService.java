package com.example.email_program.service.impl;

import com.example.email_program.model.Email;
import com.example.email_program.service.IEmailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService implements IEmailService {
    private static List<String> languages;
    private static List<Integer> sizes;
    private static List<Email> emails = new ArrayList<>();
    private static Email email = new Email("Vienamese", 20, true, "Nguyễn Anh Nhàn");

    static {
        languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        sizes = new ArrayList<>();
        sizes.add(25);
        sizes.add(5);
        sizes.add(10);
        sizes.add(15);
        sizes.add(20);
        sizes.add(50);
        sizes.add(100);
    }

    @Override
    public List<String> getLanguage() {
        return languages;
    }

    @Override
    public List<Integer> getSize() {
        return sizes;
    }

    @Override
    public void editEmails(Email editEmail) {
        email.setLanguage(editEmail.getLanguage());
        email.setSize(editEmail.getSize());
        email.setSpamFilter(editEmail.isSpamFilter());
        email.setSignature(editEmail.getSignature());
    }

    @Override
    public Email getEmail() {
        return email;
    }
}
