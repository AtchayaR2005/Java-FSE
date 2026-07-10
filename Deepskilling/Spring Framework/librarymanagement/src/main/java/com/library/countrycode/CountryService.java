package com.library.countrycode;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CountryService {

    private final Map<String, Country> countries = new HashMap<>();

    public CountryService() {
        countries.put("IN", new Country("IN", "India"));
        countries.put("US", new Country("US", "United States"));
        countries.put("JP", new Country("JP", "Japan"));
    }

    public Country getCountry(String code) {
        return countries.get(code.toUpperCase());
    }
}
