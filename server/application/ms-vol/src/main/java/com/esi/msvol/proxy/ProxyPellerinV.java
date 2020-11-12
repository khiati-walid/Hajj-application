package com.esi.msvol.proxy;

import com.esi.msvol.model.Participant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ms-gestion-pelerin")
public interface ProxyPellerinV {
    @GetMapping("/participants/search/findParticipantByIdVol")
    CollectionModel<Participant> getLesPellerins(@RequestParam("idVol") Long numVol, @RequestParam("projection") String projection);
}
