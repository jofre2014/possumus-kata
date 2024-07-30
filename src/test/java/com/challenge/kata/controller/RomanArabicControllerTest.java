package com.challenge.kata.controller;

import com.challenge.kata.service.RomanToArabicConverterService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class RomanArabicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private RomanToArabicConverterService romanNumberService;

    @Test
    void testConvertToRoman() throws Exception {
        int number = 1987;
        String expectedRoman = "MCMLXXXVII";

        when(romanNumberService.convertToRoman(number)).thenReturn(expectedRoman);

        mockMvc.perform(get("/api/to-roman")
                        .param("number", String.valueOf(number))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedRoman));
    }

    @Test
    void testConvertToArabic() throws Exception {
        String roman = "MCMLXXXVII";
        int expectedNumber = 1987;

        when(romanNumberService.convertToArabic(roman)).thenReturn(expectedNumber);

        mockMvc.perform(get("/api/to-arabic")
                        .param("roman", roman)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expectedNumber)));
    }
}
