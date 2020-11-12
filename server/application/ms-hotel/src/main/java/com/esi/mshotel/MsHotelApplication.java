package com.esi.mshotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsHotelApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsHotelApplication.class, args);
    }

}
