package com.esi.mshotel.proxy;

import com.esi.mshotel.model.Pellerin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ms-pellerin")
public interface ProxyPellerin {
    @GetMapping("/pellerins/search/findPellerinByNumHotel")
    CollectionModel<Pellerin> getLesPellerins(@RequestParam("numHotel") Long numHotel, @RequestParam("projection") String projection);
}
