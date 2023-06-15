package com.example.tu_dien_don_gian.repository.impl;

import com.example.tu_dien_don_gian.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static Map<String, String> mapDictionary = new HashMap<>();

    static {
        mapDictionary.put("hello", "Xin Chào");
        mapDictionary.put("spring", "Mùa Xuân");
    }

    public Map<String, String> getAll() {
        return mapDictionary;
    }

    public DictionaryRepository() {
    }
}
