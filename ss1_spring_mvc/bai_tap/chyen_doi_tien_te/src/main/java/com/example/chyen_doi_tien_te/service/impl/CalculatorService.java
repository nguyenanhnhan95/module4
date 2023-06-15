package com.example.chyen_doi_tien_te.service.impl;

import com.example.chyen_doi_tien_te.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String getResult(double usd) {
        String result;
        if (usd > 0) {
            return usd*23000 + "VND";
        }
        return "Vui lòng nhập số lớn hơn không";
    }
}
