package steammachinist.relexinternshiptask.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }
}
