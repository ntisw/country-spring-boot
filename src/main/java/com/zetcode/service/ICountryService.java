/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zetcode.service;

import java.util.ArrayList;
import com.zetcode.bean.Country;

/**
 *
 * @author nthop
 */
public interface ICountryService {
    public ArrayList<Country> findByContinent(String continent);
    public ArrayList<Country> findByCountry(String name);
}
