package com.example.hajjmanagementapp.entities;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "tovol", types = Participant.class)
public interface PellerinProjectionV {


    @Value("#{target.familyName}")
    public String getNomPellerin();

    @Value("#{target.firstName}")
    public String getPrenomPellerin();
}
