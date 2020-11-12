package com.esi.mshotel.service;

import com.esi.mshotel.dao.HotelsDao;
import com.esi.mshotel.exceptions.RecordAlreadyPresentException;
import com.esi.mshotel.exceptions.RecordNotFoundException;
import com.esi.mshotel.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelsServiceImpl implements HotelsService {
    @Autowired
    HotelsDao hotelsDao;

    @Override
    public ResponseEntity<Hotel> addHotel(Hotel hotel) {
        hotel.setId_hotel(0L);
        try {
            if (!hotelsDao.findById(hotel.getId_hotel()).isPresent()
                    && hotelsDao.findHotelByNomHotel(hotel.getNomHotel()).isEmpty()) {
                hotelsDao.save(hotel);
                return new ResponseEntity<>(hotel, HttpStatus.OK);
            } else
                throw new RecordAlreadyPresentException("L'hôtel " + hotel.getNomHotel() + " existe déjà");
        } catch (RecordAlreadyPresentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Iterable<Hotel> viewAllHotel() {
        return hotelsDao.findAll();
    }

    @Override
    public Hotel viewHotel(Long id_hotel) {
        Optional<Hotel> findById = hotelsDao.findById(id_hotel);
        if (findById.isPresent()) {
            return findById.get();
        } else
            throw new RecordNotFoundException("Hotel avec l'ID " + id_hotel + " n'existe pas");
    }

    @Override
    public Hotel modifyHotel(Hotel hotel) {
        if (!hotelsDao.findById(hotel.getId_hotel()).isPresent())
            throw new RecordNotFoundException("Hotel avec l'ID " + hotel.getId_hotel() + " n'existe pas");
        else
            hotelsDao.save(hotel);
        return hotel;
    }

    public String removeHotel(Long id_hotel) {
        if (hotelsDao.findById(id_hotel).isPresent()) {
            hotelsDao.deleteById(id_hotel);
            return "Hotel supprimé avec succès";
        } else
            throw new RecordNotFoundException("Hotel avec l'ID " + id_hotel + " n'existe pas");

    }
}
