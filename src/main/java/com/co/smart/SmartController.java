package com.co.smart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmartController {

    @GetMapping("api/test")
    public String test() {

        try {
            Consumer.consume();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "OK";
    }

}
