package com.example.demohbase.web;

import com.example.demohbase.entity.City;
import com.example.demohbase.service.CityService;
import com.example.demohbase.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

//    @Autowired
    private CityService cityService = new CityServiceImpl();

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<City> getAllCity() {
        return cityService.queryAll();
    }

}