package com.example.jacksonloadmodulesissue.controller.localdatetime;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
class LocalDateTimeControllerRestTemplateIntegrationTest {

    @LocalServerPort
    int port;

    @WithMockUser
    @Test
    void shouldPrintLocalDateTimeAsISO() {
        String url = "http://localhost:" + port;
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<LocalDateTimeWrapperBean> response = testRestTemplate.
                getForEntity(url + "/testLocalDateTime", LocalDateTimeWrapperBean.class);

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response.getBody().getLocalDateTime()).isNotNull();
        Assertions.assertThat(response.getBody().getLocalDateTime().toString()).isEqualTo(LocalDateTimeWrapperBean.VALUE);
    }


}
