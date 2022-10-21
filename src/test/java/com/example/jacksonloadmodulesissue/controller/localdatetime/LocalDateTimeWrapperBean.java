package com.example.jacksonloadmodulesissue.controller.localdatetime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
@Jacksonized
public class LocalDateTimeWrapperBean {
    public static final String VALUE = "2022-10-21T07:14:54.086614400";
    private LocalDateTime localDateTime;
}
