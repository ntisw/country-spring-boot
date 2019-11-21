/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zetcode.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.zetcode.bean.Country;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nthop
 */
@Service
public class CountryService implements ICountryService {

    private final ArrayList<Country> countries;

    public CountryService() {
        this.countries = new ArrayList<>();
    }

    @Override
    public ArrayList<Country> findByContinent(String continent) {
        readCSV(continent, 2);
        return countries;
    }

    @Override
    public ArrayList<Country> findByCountry(String country) {
        readCSV(country, 1);
        return countries;
    }

    private void readCSV(String name, int type) {
        countries.clear();
        FileInputStream fis;
        try {
            String fileName = "src/main/resources/countries.csv";
            fis = new FileInputStream(new File(fileName));
            CSVReader reader = new CSVReader(new InputStreamReader(fis));
            String[] nextLine;
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                if (type == 1) {
                    Country newCountry = new Country(nextLine[0], Integer.valueOf(nextLine[1]), nextLine[2]);
                    if (newCountry.getName().equals(name)) {
                        countries.add(newCountry);
                    }
                } else if (type == 2) {
                    Country newCountry = new Country(nextLine[0], Integer.valueOf(nextLine[1]), nextLine[2]);
                    if (newCountry.getContinent().equals(name)) {
                        countries.add(newCountry);
                    }
                }

            }
        } catch (CsvValidationException | IOException | NumberFormatException e) {
            System.out.println("Error:" + e.getMessage());
            Logger.getLogger(CountryService.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {

            } catch (Exception e) {
                System.out.println("Error:" + e.getMessage());
                Logger.getLogger(CountryService.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }
}
