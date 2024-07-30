package com.challenge.kata.service.impl;

import com.challenge.kata.exception.RomanArabicConverterException;
import com.challenge.kata.service.RomanToArabicConverterService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.challenge.kata.util.RomanNumberUtil.ROMAN_NUMERALS;

@Service
public class RomanArabicConverterServiceImpl implements RomanToArabicConverterService {

    @Override
    public String convertToRoman(int number) {
        if (number <= 0) {
            throw new RomanArabicConverterException("The number must be positive");
        }

        StringBuilder roman = new StringBuilder();

        for (Map.Entry<Integer, String> entry : ROMAN_NUMERALS.entrySet()) {
            while (number >= entry.getKey()) {
                roman.append(entry.getValue());
                number -= entry.getKey();
            }
        }

        return roman.toString();
    }


    @Override
    public int convertToArabic(String roman) {
        if (roman == null || roman.isEmpty()) {
            throw new RomanArabicConverterException("The roman numeral must not be null or empty");
        }

        int total = 0;
        int prevValue = 0;
        Map<String, Integer> romanNumeralsInverted = new HashMap<>();

        for (Map.Entry<Integer, String> entry : ROMAN_NUMERALS.entrySet()) {
            romanNumeralsInverted.put(entry.getValue(), entry.getKey());
        }

        for (int i = roman.length() - 1; i >= 0; i--) {
            String currentSymbol = String.valueOf(roman.charAt(i));
            Integer currentValue = romanNumeralsInverted.get(currentSymbol);

            if (currentValue == null) {
                throw new RomanArabicConverterException("Invalid roman numeral: " + roman);
            }

            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            prevValue = currentValue;
        }

        return total;
    }
}
