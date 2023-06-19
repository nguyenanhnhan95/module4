package com.example.spices_sandwich.service.impl;

import com.example.spices_sandwich.service.ISandwichService;
import org.springframework.stereotype.Service;

@Service
public class SandwichService implements ISandwichService {

    @Override
    public String checkChoice(String[] condiment) {
        if (condiment.length == 0) {
            return "Vui lòng lựa chọn gia vị";
        }
        return "";
    }
}
