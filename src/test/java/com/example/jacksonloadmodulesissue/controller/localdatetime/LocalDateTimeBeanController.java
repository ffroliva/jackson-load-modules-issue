package com.example.jacksonloadmodulesissue.controller.localdatetime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Controller
@RestController
class LocalDateTimeBeanController {

    @GetMapping("/testLocalDateTime")
    LocalDateTimeWrapperBean test() {
        return LocalDateTimeWrapperBean.builder()
                .localDateTime(LocalDateTime.parse(LocalDateTimeWrapperBean.VALUE))
                .build();


    }


}

