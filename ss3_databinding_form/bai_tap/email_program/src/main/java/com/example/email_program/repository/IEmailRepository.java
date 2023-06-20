package com.example.email_program.repository;

import com.example.email_program.model.Email;

import java.util.List;

public interface IEmailRepository {
    Email getEmail();

    List<String> getLanguages();

    List<Integer> getSizes();
}
