package com.example.hajjmanagementapp.proxy;


import com.example.hajjmanagementapp.model.Hotel;
import com.example.hajjmanagementapp.model.Vol;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-hotel")
public interface HotelProxy {


    @GetMapping("/hotels/{id}")
    public Hotel getHotel(@PathVariable("id")Long idh);
}
