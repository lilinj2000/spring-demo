package com.example.demohbase.service.impl;

import com.example.demohbase.dao.CityDao;
import com.example.demohbase.entity.City;
import com.example.demohbase.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityRepository;

    public List<City> queryAll() {
        return cityRepository.findAll();
    }
}
