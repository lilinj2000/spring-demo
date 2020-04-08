package com.example.demohbase.web;

import com.example.demohbase.utils.HBaseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        String msg = "";

        boolean test_exist = HBaseUtil.getInstance().tableExists("test_table");
        if (test_exist) {
            msg = "test exist.";
        } else {
            msg = "test not exist.";
        }

        boolean city_exist = HBaseUtil.getInstance().tableExists("city");
        if (city_exist) {
            msg += " city exist";
        } else {
            msg += " city not exist";
        }

        return msg;
    }
}
