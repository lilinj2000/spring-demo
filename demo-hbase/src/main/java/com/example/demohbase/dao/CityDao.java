package com.example.demohbase.dao;

import com.example.demohbase.entity.City;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;

import java.util.List;

public class CityDao {

    @Autowired
    private HbaseTemplate hbaseTemplate;

    private String tableName = "city";
    private static byte[] COLUMN_FAMILY = "f".getBytes();
    private static byte[] NAME = "name".getBytes();
    private static byte[] AGE = "age".getBytes();

    public List<City> findAll() {
        return hbaseTemplate.find(tableName, "f", new RowMapper<City>() {
            @Override
            public City mapRow(Result result, int rowNum) throws Exception {
                String name = Bytes.toString(result.getValue(COLUMN_FAMILY, NAME));
                int age = Bytes.toInt(result.getValue(COLUMN_FAMILY, AGE));

                City city = new City();
                city.setAge(age);
                city.setCityName(name);

                return city;
            }
        });

    }

}
