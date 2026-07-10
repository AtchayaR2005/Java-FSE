package com.library.countryxml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping("/country")
    public Country getCountry() {
        return service.getCountry();
    }

}
