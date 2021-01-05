package com.example.demohive.web;

import com.example.demohive.utils.HBaseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/hive")
public class HiveController {

    private static final Logger logger = LoggerFactory.getLogger(HiveController.class);

//    @Autowired
//    private HiveConfig hiveConfig;

    @Autowired
    @Qualifier("hiveTemplate")
    JdbcTemplate hiveTemplate;

    @RequestMapping(value = "/showTables", method = RequestMethod.POST)
    public List<String> showTables() {
        List<String> list = new ArrayList<>();
        // Statement statement = jdbcDataSource.getConnection().createStatement();
//        Statement statement = druidDataSource.getConnection().createStatement();
        String sql = "show tables";
        logger.info("Running: " + sql);
//        list.add(hiveConfig.getUrl());
//        list.add(hiveConfig.getDriverClassName());
//        list.add("test001");
//        list.add("test002");
        list = hiveTemplate.queryForList(sql, String.class);
//        ResultSet res = statement.executeQuery(sql);
//        while (res.next()) {
//            list.add(res.getString(1));
//        }
        return list;

    }

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