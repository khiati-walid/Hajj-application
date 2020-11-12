package com.esi.mshotel.entities;

//import com.esi.model.Etudiant;

import com.esi.mshotel.model.Pellerin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_hotel;
    private String nomHotel;
    private String localisation;
    private String adresse;
    private int capacite;
    private int nbReserve = 0;

    @Transient
    private Collection<Pellerin> pellerins;

    public Long getId_hotel() {
        return id_hotel;
    }

    public String getNomHotel() {
        return nomHotel;
    }
}
