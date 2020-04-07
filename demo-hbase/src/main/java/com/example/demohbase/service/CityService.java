package com.example.demohbase.service;

import com.example.demohbase.entity.City;

import java.util.List;

public interface CityService {

    List<City> queryAll();

//    List<City> query(String startRow, String stopRow);

//    public City query(String row);
//
//    void saveOrUpdate();
}