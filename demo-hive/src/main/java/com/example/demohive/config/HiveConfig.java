package com.example.demohive.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@Configuration

public class HiveConfig {
//    private String url;
//    private String driverClassName;
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public String getDriverClassName() {
//        return driverClassName;
//    }
//
//    public void setDriverClassName(String driverClassName) {
//        this.driverClassName = driverClassName;
//    }

    @Bean(name = "hiveDataSource")
    @Qualifier("hiveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hive")
    public DataSource dataSource() {
        DataSource dataSource = DataSourceBuilder.create().build();
//        DataSource dataSource = new DataSource();
//        dataSource.setUrl(url);
//        dataSource.setDriverClassName(driverClassName);

        return dataSource;
    }

    @Bean(name = "hiveTemplate")
    public JdbcTemplate hiveTemplate(@Qualifier("hiveDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
