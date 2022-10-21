package com.example.jacksonloadmodulesissue.config.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class JacksonConfiguration {

    // objectMapper has jackson-datatype-jsr310 but
    // Jackson2ObjectMapperBuilderCustomizer doesn't have
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer addCustomLocalDateTimeDeserialization() {
       return  (b) -> {
            b.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer());
            b.deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer());
        };
    }

    //@Bean
    public Module javaTimeModule() {
        return new JavaTimeModule();
    }
}
