/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zetcode.controller;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zetcode.bean.Country;
import com.zetcode.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author nthop
 */
@RestController
public class CountryController {
    @Autowired
    private ICountryService countryService;
    
    @RequestMapping("/country/{country}")
    public List<Country> findByCountry(@PathVariable String country){
        return countryService.findByCountry(country);
    }
    @RequestMapping("/continent/{continent}")
    public List<Country> findByContinent(@PathVariable String continent){
        return countryService.findByContinent(continent);
    }
}
