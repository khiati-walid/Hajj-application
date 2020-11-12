package com.example.hajjmanagementapp.web;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.esi.msvol.dao.volRepository;
import com.example.hajjmanagementapp.dao.MedecinRepository;
import com.example.hajjmanagementapp.entities.Medecin;
import com.example.hajjmanagementapp.model.Vol;
import com.example.hajjmanagementapp.proxy.VolProxy;
import com.example.hajjmanagementapp.sec.SecurityParams;
import com.example.hajjmanagementapp.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
public class AdminController {


    @Autowired
    MedecinRepository medecinRepository;

    @Autowired
    MedecinService medecinService;

    @Autowired
    VolProxy volProxy;


    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public AdminController(BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @PostMapping("/add-Medecin")
    public Medecin addMedecin(@RequestBody Map<String, Object> payload) {

        Medecin medecinOrdi = medecinService.saveMedecin(
                payload.get("username").toString(),
                payload.get("Residence").toString(),
                payload.get("password").toString()
        );
        return medecinOrdi;
    }

    @PostMapping("/login-medecin")

    public void loginMedecin(@RequestBody Map<String, Object> payload, HttpServletRequest request, HttpServletResponse response) {
        String username = payload.get("username").toString();

        String password = payload.get("password").toString();


        for (Medecin medecin : medecinRepository.findAll()) {
            //  System.out.println(bCryptPasswordEncoder.matches(password,medecin.getPassword()));
            if (medecin.getUsername().equals(username) && bCryptPasswordEncoder.matches(password, medecin.getPassword())) {
                System.out.println("*************************** ");
                String jwt = JWT.create()
                        .withIssuer(request.getRequestURI())
                        .withSubject(medecin.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + SecurityParams.EXPIRATION))
                        .sign(Algorithm.HMAC256(SecurityParams.SECRET));
                System.out.println(jwt);
                response.addHeader(SecurityParams.JWT_HEADER_NAME, jwt);
            }
        }
    }

    // aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa


 /*   @GetMapping(value = "vols/lieu/{lieu}")
    public List<com.esi.msvol.entities.Vol> findByLieudarrive(@PathVariable String lieu) {

        List<com.esi.msvol.entities.Vol> vols = volProxy.findByLieudarrive(lieu);
        return vols;
    }

    @PostMapping(value = "/vols/create")
    public com.esi.msvol.entities.Vol postVol(@RequestBody Vol vol) {

        com.esi.msvol.entities.Vol _vol = volProxy.create(new com.esi.msvol.entities.Vol(vol.getDatedepart(), vol.getDatedarrive(), vol.getLieudepart(), vol.getAgance(), vol.getAvion(), vol.getLieudarrive()));
        return _vol;
    }

    @DeleteMapping("/vols/{id}")
    public ResponseEntity<String> deleteVol(@PathVariable("id") long id) {
        System.out.println("Delete vol with ID = " + id + "...");

        volProxy.deleteById(id);

        return new ResponseEntity<>("vol has been deleted!", HttpStatus.OK);
    }*/
/*
    @DeleteMapping("/vols/delete")
    public ResponseEntity<String> deleteAllVols() {
        System.out.println("Delete All Vols...");

        volProxy.deleteAll();

        return new ResponseEntity<>("All Vols have been deleted!", HttpStatus.OK);
    }

    @PutMapping("/vols/{id}")
    public ResponseEntity<com.esi.msvol.entities.Vol> updateVols(@PathVariable("id") long id, @RequestBody com.esi.msvol.entities.Vol vol) {
        System.out.println("Update Vol with ID = " + id + "...");

        Optional<com.esi.msvol.entities.Vol> voldata = volProxy.findById(id);

        if (voldata.isPresent()) {
            com.esi.msvol.entities.Vol _vol = voldata.get();
            _vol.setDatedepart(vol.getDatedepart());
            _vol.setDatedarrive(vol.getDatedarrive());
            _vol.setLieudepart(vol.getLieudepart());
            _vol.setAgance(vol.getAgance());
            _vol.setAvion(vol.getAvion());
            return new ResponseEntity<>(volProxy.save(_vol), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("getVol/{id}")
//    com.esi.msvol.entities.Vol getVolWithPellerins(@PathVariable("id") Long id) {
  //      com.esi.msvol.entities.Vol vol = volRepository.findById(id).get();
    //    vol.setPellerins(new ArrayList<>(proxyPellerinV.getLesPellerins(id, "tovol").getContent()));
      //  return vol;
   // }
   */

}






