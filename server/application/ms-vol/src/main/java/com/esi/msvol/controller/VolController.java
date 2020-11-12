package com.esi.msvol.controller;//package com.esi.mspellerin.controller;

import com.esi.msvol.dao.volRepository;
import com.esi.msvol.entities.Vol;
import com.esi.msvol.proxy.ProxyPellerinV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class VolController {

	@Autowired
	volRepository repository;
	@Autowired
	ProxyPellerinV proxyPellerinV;

	@GetMapping("/vols")
	public List<Vol> getAllVols() {
		System.out.println("Get all Vols...");

		List<Vol> vols = new ArrayList<>();
		repository.findAll().forEach(vols::add);

		return vols;
	}

	@GetMapping(value = "vols/lieu/{lieu}")
	public List<Vol> findByLieudarrive(@PathVariable String lieu) {

		List<Vol> vols = repository.findByLieudarrive(lieu);
		return vols;
	}

	@PostMapping(value = "/vols/create")
	public Vol postVol(@RequestBody Vol vol) {

		Vol _vol = repository.save(new Vol(vol.getDatedepart(),vol.getDatedarrive(),vol.getLieudepart(),vol.getAgance(),vol.getAvion(),vol.getLieudarrive()));
		return _vol;
	}

	@DeleteMapping("/vols/{id}")
	public ResponseEntity<String> deleteVol(@PathVariable("id") long id) {
		System.out.println("Delete vol with ID = " + id + "...");

		repository.deleteById(id);

		return new ResponseEntity<>("vol has been deleted!", HttpStatus.OK);
	}

	@DeleteMapping("/vols/delete")
	public ResponseEntity<String> deleteAllVols() {
		System.out.println("Delete All Vols...");

		repository.deleteAll();

		return new ResponseEntity<>("All Vols have been deleted!", HttpStatus.OK);
	}

	@PutMapping("/vols/{id}")
	public ResponseEntity<Vol> updateVols(@PathVariable("id") long id, @RequestBody Vol vol) {
		System.out.println("Update Vol with ID = " + id + "...");

		Optional<Vol> voldata = repository.findById(id);

		if (voldata.isPresent()) {
			Vol _vol = voldata.get();
			_vol.setDatedepart(vol.getDatedepart());
			_vol.setDatedarrive(vol.getDatedarrive());
			_vol.setLieudepart(vol.getLieudepart());
			_vol.setAgance(vol.getAgance());
			_vol.setAvion(vol.getAvion());
			return new ResponseEntity<>(repository.save(_vol), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("getVol/{id}")
	 Vol getVolWithPellerins(@PathVariable("id") Long id) {
		Vol vol = repository.findById(id).get();
		vol.setPellerins(new ArrayList<>(proxyPellerinV.getLesPellerins(id, "tovol").getContent()));
		return vol;
	}
}
