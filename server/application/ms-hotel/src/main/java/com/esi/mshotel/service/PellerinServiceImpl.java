package com.esi.mshotel.service;//package com.esi.service;
//
//import com.esi.dao.PellerinRepository;
//import com.esi.entities.Pellerin;
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
//public class PellerinServiceImpl implements PellerinService {
//    @Autowired
//    PellerinRepository pellerinRepository;
//
//    @Override
//    public ResponseEntity<Pellerin> addPellerin(Pellerin pellerin) {
//        pellerin.setNumPasseport(0L);
//        try {
//            if (!pellerinRepository.findById(pellerin.getNumPasseport()).isPresent()) {
//                pellerinRepository.save(pellerin);
//                return new ResponseEntity<>(pellerin, HttpStatus.OK);
//            } else
//                throw new RecordAlreadyPresentException("Le pellerin " + pellerin.getNumPasseport() + " existe déjà");
//        } catch (RecordAlreadyPresentException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @Override
//    public Iterable<Pellerin> viewAllPellerins() {
//        return pellerinRepository.findAll();
//    }
//
////    @Override
////    public Pellerin viewPellerin(Long numPasseport) {
////        Optional<Pellerin> findById = pellerinRepository.findById(numPasseport);
////        if (findById.isPresent()) {
////            return findById.get();
////        } else
////            throw new RecordNotFoundException("Le pellerin avec le numéro de passeport " + numPasseport + " n'existe pas");
////    }
//    @Override
//    public Pellerin viewPellerin(Long numPasseport) {
//        Optional<Pellerin> findById=pellerinRepository.findById(numPasseport);
//        return findById.get();
//    }
//
//    @Override
//    public Pellerin modifyPellerin(Pellerin pellerin) {
//        if (!pellerinRepository.findById(pellerin.getNumPasseport()).isPresent())
//            throw new RecordNotFoundException("Pellerin avec l'ID " + pellerin.getNumPasseport() + " n'existe pas");
//        else
//            pellerinRepository.save(pellerin);
//        return pellerin;
//    }
//
//    public String removePellerin(Long numPasseport) {
//        if (pellerinRepository.findById(numPasseport).isPresent()) {
//            pellerinRepository.deleteById(numPasseport);
//            return "Pellerin supprimé avec succès";
//        } else
//            throw new RecordNotFoundException("Pellerin avec l'ID " + numPasseport + " n'existe pas");
//
//    }
//}
//
