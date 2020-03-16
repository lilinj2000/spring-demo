package com.example.democonsulprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoConsulProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoConsulProviderApplication.class, args);
    }

}
