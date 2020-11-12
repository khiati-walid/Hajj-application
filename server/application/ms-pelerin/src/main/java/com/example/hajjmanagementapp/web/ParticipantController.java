package com.example.hajjmanagementapp.web;


import com.example.hajjmanagementapp.dao.ParticipantRepository;
import com.example.hajjmanagementapp.entities.Genre;
import com.example.hajjmanagementapp.entities.Participant;
import com.example.hajjmanagementapp.model.Hotel;
import com.example.hajjmanagementapp.model.Vol;
import com.example.hajjmanagementapp.proxy.HotelProxy;
import com.example.hajjmanagementapp.proxy.VolProxy;
import com.example.hajjmanagementapp.service.ParticipantService;
import com.google.inject.internal.cglib.core.$ClassInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;




@RestController
public class ParticipantController {

    @Autowired
    ParticipantService participantService;


    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    VolProxy volProxy;

    @Autowired
    HotelProxy hotelProxy;



    @GetMapping("/get-Profile")
    public Participant getProfile(Authentication authentication){
        return participantService.loadParticipantByEmail(authentication.getName());

    }



    @PostMapping("/add-Participant")
    public Participant addParticipant(@RequestBody Map<String,Object> payload)

    {
        String genre =    payload.get("genre").toString();

     Participant participantOrdi=   participantService.saveParticipant(Long.parseLong(payload.get("numPassport").toString()),
                payload.get("username").toString(),payload.get("firstName").toString(),
                payload.get("familyName").toString(),
                payload.get("email").toString(),
                payload.get("numPhone").toString(),
                payload.get("Residence").toString(),
                Integer.parseInt(payload.get("nbInscription").toString()),
                genre,
                payload.get("password").toString(),
                payload.get("passConfirmed").toString()
             ///   Long.parseLong(payload.get("idVol").toString()),
              ///  Long.parseLong(payload.get("idHotel").toString())

                );

        DateTimeFormatter formatterDate=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate= LocalDate.parse(payload.get("birthDate").toString(),formatterDate);
        participantOrdi.setBirthDate(birthDate);
        LocalDate today = LocalDate.now();                          //Today's date
        LocalDate birthday = LocalDate.of(birthDate.getYear(),birthDate.getMonth(),birthDate.getDayOfMonth());  //Birth date

        Period p = Period.between(birthday, today);

        participantOrdi.setAge(p.getYears());

        participantRepository.save(participantOrdi);


        if(genre.equals("femme")){
            payload.forEach((s,o)-> {
              if(s.contains("numPassportMahram")){
                  Participant mahram = participantRepository.findByNumPassport(Long.parseLong(o.toString()));
                  if(mahram!=null){
                      participantOrdi.setIsMahram(true); participantOrdi.setParticipant(mahram);
                      participantRepository.save(participantOrdi);
                  }
                  else throw new RuntimeException("We cannot find This Mahram");
              }
            });
        }
     return  participantOrdi;
    }

    @PostMapping("/tirage")
    public List<Participant> doTirage(@RequestBody Map<String,Object> payload){
        List<Participant> partilist=  participantRepository.getRandomParticipants(Integer.parseInt(payload.get("nb").toString()));
        for(int i=0;i<partilist.size();i++){
            Participant participant = partilist.get(i);
            participant.setIsPelerin(true);
            participant.setIsTakenFirstStage(true);
            participantRepository.save(participant);
            if(participant.getGenre().equals(Genre.femme) & !partilist.contains(participant.getParticipant())){
                participant.getParticipant().setIsPelerin(true);
                participant.setIsTakenFirstStage(true);
                participantRepository.save(participant);
                partilist.add(participant.getParticipant());
            }
        }
        return  partilist;
    }


    @PostMapping("/filtrage")
    public List<Participant> filtrer(@RequestBody Map<String,Object> payload){

        List<Participant> participantList = new ArrayList<>();
        for(Participant p: participantRepository.getPortionParticipant(Integer.parseInt(payload.get("nb").toString()))){
            if(!p.isIsTakenFirstStage()){
                payload.forEach((s,o)->{
                    if(s.contains("age")){
                        if(p.getAge()>Integer.parseInt(o.toString()))
                            p.setIsPelerin(true);
                        p.setIsTakenSecondStage(true);
                        participantRepository.save(p);
                        participantList.add(p);
                    }
                });
            }
        }
        return participantList;
    }


    @GetMapping("/pelerin")
    public List<Participant> showPelerin(){

        List<Participant> participantList = new ArrayList<>();
        for(Participant p: participantRepository.findAll()){
            if(p.isIsPelerin()) {
                participantList.add(p);
            }
        }
        return  participantList;
    }


    /*@GetMapping("/pelerin/vol/{id}")
    public Participant getParticipantWithVol(@PathVariable("id") Long ide){

        Participant participant = participantRepository.findById(ide).get();

        Vol vol = volProxy.getVol(participant.getIdVol());

        participant.setVol(vol);


        return participant;
    }*/

    /*@GetMapping("/pelerin/hotel/{id}")
    public Participant getParticipantWithHotel(@PathVariable("id") Long ide){

        Participant participant = participantRepository.findById(ide).get();

        Hotel hotel= hotelProxy.getHotel(participant.getIdHotel());

        participant.setHotel(hotel);

        return participant;
    }
*/



}
