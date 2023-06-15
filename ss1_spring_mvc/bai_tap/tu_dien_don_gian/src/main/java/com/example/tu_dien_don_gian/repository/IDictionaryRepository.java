package com.example.tu_dien_don_gian.repository;

import org.springframework.stereotype.Repository;

import java.util.Map;

public interface IDictionaryRepository {
    public Map<String, String> getAll();
}
