package com.example.demospringhbase.service.impl;

import com.example.demospringhbase.dao.CityRowMapper;
import com.example.demospringhbase.domain.City;
import com.example.demospringhbase.service.CityService;
import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 城市业务逻辑实现类
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired private HbaseTemplate hbaseTemplate;

    public List<City> query(String startRow, String stopRow) {
        Scan scan = new Scan(Bytes.toBytes(startRow), Bytes.toBytes(stopRow));
        scan.setCaching(5000);
        List<City> dtos = this.hbaseTemplate.find("city", scan, new CityRowMapper());
        return dtos;
    }

    public City query(String row) {
        City dto = this.hbaseTemplate.get("city", row, new CityRowMapper());
        dto.setId(row);
        return dto;
    }

    public void saveOrUpdate() {
        List<Mutation> saveOrUpdates = new ArrayList<Mutation>();
        Put            put           = new Put(Bytes.toBytes("135001"));
        put.addColumn(Bytes.toBytes("f"), Bytes.toBytes("name"), Bytes.toBytes("test"));
        put.addColumn(Bytes.toBytes("f"), Bytes.toBytes("age"), Bytes.toBytes("1"));
        saveOrUpdates.add(put);

        this.hbaseTemplate.saveOrUpdates("city", saveOrUpdates);
    }
}