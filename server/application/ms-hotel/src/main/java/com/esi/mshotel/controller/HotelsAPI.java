package com.esi.mshotel.controller;

import com.esi.mshotel.dao.HotelsDao;
import com.esi.mshotel.entities.Hotel;
import com.esi.mshotel.exceptions.RecordAlreadyPresentException;
import com.esi.mshotel.exceptions.RecordNotFoundException;
import com.esi.mshotel.proxy.ProxyPellerin;
import com.esi.mshotel.service.HotelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/hotel")
@CrossOrigin(origins = "http://localhost:4200")
public class HotelsAPI {
    @Autowired
    HotelsService hotelsService;
    @Autowired
    HotelsDao hotelsDao;
    @Autowired
    ProxyPellerin pellerinProxy;

    @PostMapping("/addHotel")
    @ExceptionHandler(RecordAlreadyPresentException.class)
    public void addHotel(@RequestBody Hotel hotel) {
        hotelsService.addHotel(hotel);
    }

    @GetMapping("/allHotel")
    public Iterable<Hotel> viewAllHotel() {
        return hotelsService.viewAllHotel();
    }

    @GetMapping("/viewHotel/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public Hotel viewHotel(@PathVariable("id") Long id_hotel) {
        return hotelsService.viewHotel(id_hotel);
    }

    @PutMapping("/updateHotel")
    @ExceptionHandler(RecordNotFoundException.class)
    public void modifyHotel(@RequestBody Hotel hotel) {
        hotelsService.modifyHotel(hotel);
    }

    @DeleteMapping("/deleteHotel/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public void removeHotel(@PathVariable("id") Long id_hotel) {
        hotelsService.removeHotel(id_hotel);
    }

    @GetMapping("/hotels/{id}")
    Hotel getHotelWithPellerins(@PathVariable("id") Long id) {
        Hotel hotel = hotelsDao.findById(id).get();
        hotel.setPellerins(new ArrayList<>(pellerinProxy.getLesPellerins(id, "tohotel").getContent()));
        return hotel;
    }
}
