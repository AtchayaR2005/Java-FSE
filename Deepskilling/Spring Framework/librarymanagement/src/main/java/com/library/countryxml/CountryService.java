package com.library.countryxml;

import org.springframework.stereotype.Service;

@Service
public class CountryService {

    public Country getCountry() {
        return new Country("IN", "India");
    }

}