package es.codeurjc.app.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.codeurjc.app.entity.Casa;
import es.codeurjc.app.service.CasaService;

@RestController
@RequestMapping("/api/casas")
public class CasaRestController {

	@Autowired
	private CasaService service;

	@GetMapping("/")
	public Collection<Casa> getCasas() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Casa> getCasa(@PathVariable long id) {

		Optional<Casa> op = service.findById(id);
		if (op.isPresent()) {
			Casa casa = op.get();
			return new ResponseEntity<>(casa, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Casa createCasa(@RequestBody Casa casa) {

		service.save(casa);

		return casa;
	}

	@PutMapping("/{id}")
	public ResponseEntity<Casa> updateCasa(@PathVariable long id, 
			@RequestBody Casa updatedCasa) {

		if (service.exist(id)) {

			updatedCasa.setId(id);
			service.save(updatedCasa);

			return new ResponseEntity<>(updatedCasa, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Casa> deleteCasa(@PathVariable long id) {

		try {
			service.delete(id);
			return new ResponseEntity<>(null, HttpStatus.OK);

		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
}
