package com.library.countrycode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping("/country/{code}")
    public Country getCountry(@PathVariable String code) {
        return service.getCountry(code);
    }
}
