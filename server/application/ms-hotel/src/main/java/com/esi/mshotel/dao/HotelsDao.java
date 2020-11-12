package com.esi.mshotel.dao;

import com.esi.mshotel.entities.Hotel;
//import com.esi.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelsDao extends JpaRepository<Hotel, Long> {

        List<Hotel> findHotelByNomHotel(String nomHotel);
//        List<Etudiant> findHotelWithEtudiants(Long id_hotel);

}
