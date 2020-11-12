package com.esi.msvol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsVolApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsVolApplication.class, args);
    }

}
