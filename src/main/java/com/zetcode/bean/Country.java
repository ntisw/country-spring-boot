/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zetcode.bean;

/**
 *
 * @author nthop
 */
public class Country {
    private String name;
    private int population;
    private String continent;

    public Country(String name, int population, String continent) {
        this.name = name;
        this.population = population;
        this.continent = continent;
    }

    public Country() {
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public String getContinent() {
        return continent;
    }
    
}
