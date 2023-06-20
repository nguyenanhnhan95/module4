package com.example.email_program.repository.impl;

import com.example.email_program.model.Email;
import com.example.email_program.repository.IEmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository {
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
    public Email getEmail() {
        return email;
    }

    @Override
    public List<String> getLanguages() {
        return languages;
    }

    @Override
    public List<Integer> getSizes() {
        return sizes;
    }
}
