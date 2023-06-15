package com.example.tu_dien_don_gian.service.impl;

import com.example.tu_dien_don_gian.repository.impl.DictionaryRepository;
import com.example.tu_dien_don_gian.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Override
    public String getResult(String english) {
        Map<String, String> stringMap = dictionaryRepository.getAll();
        for (String key : stringMap.keySet()) {
            if (key.equals(english)) {
                return stringMap.get(key);
            }
        }
        return "Bạn nhập không đúng";
    }
}
