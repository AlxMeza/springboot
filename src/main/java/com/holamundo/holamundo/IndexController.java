package com.holamundo.holamundo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class IndexController {

    @GetMapping("/api/hello")
    public String getStatus () {
        log.info("Ejecutando REST Controller");
        return "Hello World by Spring";
    }
}
