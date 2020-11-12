package com.esi.mshotel.service;//package com.esi.service;
//
//import com.esi.dao.HotelsDao;
//import com.esi.dao.PellerinRepository;
//import com.esi.dao.ReservationRepository;
//import com.esi.model.Reservation;
//import com.esi.exceptions.RecordAlreadyPresentException;
//import com.esi.exceptions.RecordNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class ReservationServiceImpl implements ReservationService {
//    @Autowired
//    HotelsDao hotelsRepository;
//    @Autowired
//    ReservationRepository reservationRepository;
//    @Autowired
//    PellerinRepository pellerinRepository;
//
//    @Override
//    public Iterable<Reservation> viewAllReservation() {
//        return reservationRepository.findAll();
//    }
//
//    @Override
//    public Reservation viewReservation(Long id_reservation) {
//        Optional<Reservation> findById = reservationRepository.findById(id_reservation);
//        if (findById.isPresent()) {
//            return findById.get();
//        } else
//            throw new RecordNotFoundException("IdReservation avec l'ID " + id_reservation + " n'existe pas");
//    }
//
//    @Override
//    public ResponseEntity<?> addReservation(Reservation reservation) {
//        reservation.setId_reservation(0L);
//        try {
//            if (!reservationRepository.findById(reservation.getId_reservation()).isPresent()) {
//                reservationRepository.save(reservation);
//                return new ResponseEntity<>(reservation, HttpStatus.OK);
//            } else
//                throw new RecordAlreadyPresentException("La réservation " + reservation.getId_reservation() + " existe");
//        } catch (RecordAlreadyPresentException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//}
