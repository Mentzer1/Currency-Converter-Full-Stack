package com.example.Currency.Converter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private MainService mainService;

    @GetMapping("/convert")
    public String convert(@RequestParam String from, @RequestParam String to, @RequestParam String amount) throws IOException {
       return mainService.convert(from,to,amount);
    }

}
