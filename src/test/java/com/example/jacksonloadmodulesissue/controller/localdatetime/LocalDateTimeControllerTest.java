package com.example.jacksonloadmodulesissue.controller.localdatetime;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class LocalDateTimeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @WithMockUser
    @Test
    void shouldPrintLocalDateTimeAsISO() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/testLocalDateTime"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.localDateTime")
                        .value(LocalDateTimeWrapperBean.VALUE));
    }


}
