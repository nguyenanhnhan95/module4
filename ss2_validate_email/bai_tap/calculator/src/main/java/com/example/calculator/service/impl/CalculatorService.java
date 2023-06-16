package com.example.calculator.service.impl;

import com.example.calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String getCalculatorResult(double numberOne, double numberTwo, String calculate) {
        String result = "";
        switch (calculate) {
            case "+":
                result += (numberOne + numberTwo);
                break;
            case "-":
                result += (numberOne - numberTwo);
                break;
            case "*":
                result += (numberOne * numberTwo);
                break;
            case "/":
                if (numberTwo == 0) {
                    result += "Vui lòng nhập mẫu số khác không";
                } else {
                    result += (numberOne / numberTwo);
                }
                break;
        }
        return result;
    }
}
