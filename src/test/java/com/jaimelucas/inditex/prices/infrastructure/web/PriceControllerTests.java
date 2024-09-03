package com.jaimelucas.inditex.prices.infrastructure.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTests {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void testGetPrice1() throws Exception{
        mockMvc.perform(get("/price")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("applicationDate", "2020-06-14 10:00:00"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("35.5")));
    }

    @Test
    void testGetPrice2() throws Exception{
        mockMvc.perform(get("/price")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14 16:00:00"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("25.45")));
    }

    @Test
    void testGetPrice3() throws Exception{
        mockMvc.perform(get("/price")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14 21:00:00"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("35.5")));
    }

    @Test
    void testGetPrice4() throws Exception{
        mockMvc.perform(get("/price")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-15 10:00:00"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("30.5")));
    }

    @Test
    void testGetPrice5() throws Exception{
        mockMvc.perform(get("/price")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-16 21:00:00"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("38.95")));
    }
}
