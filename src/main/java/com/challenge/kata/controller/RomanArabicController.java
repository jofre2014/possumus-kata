package com.challenge.kata.controller;

import com.challenge.kata.service.RomanToArabicConverterService;
import com.challenge.kata.validator.NumberConstraint;
import com.challenge.kata.validator.RomanConstraint;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Validated
public class RomanArabicController {

    private final RomanToArabicConverterService romanNumberService;

    public RomanArabicController(RomanToArabicConverterService romanNumberService) {
        this.romanNumberService = romanNumberService;
    }


    @GetMapping(value = "/to-roman")
    public ResponseEntity<String> getRoman(@RequestParam("number") @NumberConstraint String numberStr){
        int number = Integer.parseInt(numberStr);
        return ResponseEntity.ok(romanNumberService.convertToRoman(number));
    }

    @GetMapping("/to-arabic")
    public ResponseEntity<Integer> getNumber(@RequestParam @RomanConstraint String roman){
        return ResponseEntity.ok(romanNumberService.convertToArabic(roman));
    }
}
