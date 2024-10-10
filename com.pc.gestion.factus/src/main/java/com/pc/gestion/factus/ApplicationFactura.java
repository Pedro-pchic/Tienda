package com.pc.gestion.factus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class ApplicationFactura {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationFactura.class, args);
    }
}
