package ie.emeraldjava.controller;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ApiController {

    @PostConstruct
    public void xx() {
        log.info("ApiController");
    }

    @GetMapping("/api")
    public String homePage() {
        log.info("ApiController - /api");
        return "api";
    }
}
