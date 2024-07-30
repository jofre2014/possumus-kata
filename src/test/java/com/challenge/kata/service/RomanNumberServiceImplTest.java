package com.challenge.kata.service;

import com.challenge.kata.exception.RomanArabicConverterException;
import com.challenge.kata.service.impl.RomanArabicConverterServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RomanNumberServiceImplTest {

    private RomanArabicConverterServiceImpl romanNumberService;

    @BeforeEach
    void setUp() {
        romanNumberService = new RomanArabicConverterServiceImpl();
    }

    @Test
    void testConvertToRoman_ThrowsException() {
        Exception exception = assertThrows(RomanArabicConverterException.class, () -> {
            romanNumberService.convertToRoman(-1);
        });
        assertEquals("The number must be positive", exception.getMessage());
    }


    @Test
    void testConvertToRoman_400_Return_CD() {
        String result = romanNumberService.convertToRoman(400);
        assertEquals("CD", result);
    }

    @Test
    void testConvertToRoman_290_Return_CCXC() {
        String result = romanNumberService.convertToRoman(290);
        assertEquals("CCXC", result);
    }

    @Test
    void testConvertToRoman_1490_Return_MCDXC() {
        String result = romanNumberService.convertToRoman(1490);
        assertEquals("MCDXC", result);
    }

    @Test
    void testConvertToRoman_699_Return_DCXCIX() {
        String result = romanNumberService.convertToRoman(699);
        assertEquals("DCXCIX", result);
    }

    @Test
    void testConvertToRoman_19_Return_XIX() {
        String result = romanNumberService.convertToRoman(19);
        assertEquals("XIX", result);
    }

    @Test
    void testConvertToArabic_X_Return_10() {
        int result = romanNumberService.convertToArabic("X");
        assertEquals(10, result);
    }

    @Test
    void testConvertToArabic_XV_Return_15() {
        int result = romanNumberService.convertToArabic("XV");
        assertEquals(15, result);
    }

    @Test
    void testConvertToArabic_XCIV_Return_94() {
        int result = romanNumberService.convertToArabic("XCIV");
        assertEquals(94, result);
    }

    @Test
    void testConvertToArabic_invalidRomanNumber_ThrowException() {

        Exception exception = assertThrows(RomanArabicConverterException.class, () -> {
            romanNumberService.convertToArabic("AA");
        });
        assertEquals("Invalid roman numeral: AA", exception.getMessage());

    }

    @Test
    void testConvertToArabic_invalidNullOrEmptyRomanNumber_ThrowException() {

        Exception exception = assertThrows(RomanArabicConverterException.class, () -> {
            romanNumberService.convertToArabic(null);
        });
        assertEquals("The roman numeral must not be null or empty", exception.getMessage());

    }
}
