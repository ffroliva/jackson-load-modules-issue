package com.example.jacksonloadmodulesissue.config;

import com.example.jacksonloadmodulesissue.controller.localdatetime.LocalDateTimeWrapperBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@Slf4j
@SpringBootTest
class JacksonConfigurationTest {

    @Autowired
    ObjectMapper mapper;

    @Test
    void shouldPrintLocalDateTimeAsISO() throws JsonProcessingException {
        LocalDateTime aLocalDateTime = LocalDateTime.parse(LocalDateTimeWrapperBean.VALUE);
        var bean = new LocalDateTimeWrapperBean(aLocalDateTime);
        final String json = mapper.writeValueAsString(bean);
        log.info("{}", json);
        var backToBean = mapper.readValue(json, LocalDateTimeWrapperBean.class);
        Assertions.assertThat(backToBean.getLocalDateTime()).isEqualTo(aLocalDateTime);
        Assertions.assertThat(mapper.getRegisteredModuleIds()).contains("jackson-datatype-jsr310");
    }

}
