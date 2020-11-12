package com.esi.mshotel.service;

import com.esi.mshotel.entities.Hotel;
import org.springframework.http.ResponseEntity;

public interface HotelsService {

    public ResponseEntity<?> addHotel(Hotel hotel);

    public Iterable<Hotel> viewAllHotel();

    public Hotel viewHotel(Long id_hotel);

    public Hotel modifyHotel(Hotel hotel);

    public String removeHotel(Long id_hotel);

}
