package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    @Autowired
    private CountryRepository countryRepository;

    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryRepository.findAll();
        LOGGER.info("End");
        return countries;
    }

    @Transactional(readOnly = true)
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        LOGGER.info("Start");
        var result = countryRepository.findById(countryCode);
        if (result.isEmpty()) {
            throw new CountryNotFoundException("Country not found: " + countryCode);
        }
        Country country = result.get();
        LOGGER.info("End");
        return country;
    }

    @Transactional
    public void addCountry(Country country) {
        LOGGER.info("Start");
        countryRepository.save(country);
        LOGGER.info("End");
    }

    @Transactional
    public void updateCountry(String code, String name) throws CountryNotFoundException {
        LOGGER.info("Start");
        Country country = findCountryByCode(code);
        country.setName(name);
        countryRepository.save(country);
        LOGGER.info("End");
    }

    @Transactional
    public void deleteCountry(String code) {
        LOGGER.info("Start");
        countryRepository.deleteById(code);
        LOGGER.info("End");
    }

    @Transactional(readOnly = true)
    public List<Country> findCountriesByPartialName(String partialName) {
        LOGGER.info("Start");
        List<Country> countries = countryRepository.findByNameContaining(partialName);
        LOGGER.info("End");
        return countries;
    }
}
