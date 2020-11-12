package com.example.hajjmanagementapp.model;

import lombok.Data;

@Data
public class Hotel {
    private Long idh;
    private String nomHotel;
    private String localisation;
    private String adresse;

    public Hotel(Long idh,String nomHotel, String localisation, String adresse) {
        this.idh=idh;
        this.nomHotel = nomHotel;
        this.localisation = localisation;
        this.adresse = adresse;
    }
}
