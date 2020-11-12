package com.example.hajjmanagementapp.proxy;

import com.example.hajjmanagementapp.model.Vol;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@FeignClient(name = "ms-vol")
public interface VolProxy {


  /* @GetMapping("/vols/{id}")
    public Vol getVol(@PathVariable("id")Long idv);


    @GetMapping("vols/lieu/{lieu}")
    public List<com.esi.msvol.entities.Vol> findByLieudarrive(@PathVariable String lieu);


    @PostMapping(value = "/vols/create")
    com.esi.msvol.entities.Vol create(com.esi.msvol.entities.Vol vol);


    @DeleteMapping("/vols/{id}")
    ResponseEntity deleteById(long id);*/

    @GetMapping("/vols/{id}")
    public Vol getVol(@PathVariable("id")Long idv);

}
