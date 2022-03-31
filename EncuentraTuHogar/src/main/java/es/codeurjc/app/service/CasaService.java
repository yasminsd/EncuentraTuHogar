package es.codeurjc.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.app.entity.Casa;
import es.codeurjc.app.repository.CasaRepository;

@Service
public class CasaService {

	@Autowired
	private CasaRepository repository;

	public Optional<Casa> findById(long id) {
		return repository.findById(id);
	}

	public boolean exist(long id) {
		return repository.existsById(id);
	}

	public List<Casa> findAll() {
		return repository.findAll();
	}

	public void save(Casa casa) {
		repository.save(casa);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}
}
