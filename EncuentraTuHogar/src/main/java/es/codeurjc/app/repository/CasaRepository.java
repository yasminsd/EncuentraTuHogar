package es.codeurjc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.app.entity.Casa;

public interface CasaRepository extends JpaRepository<Casa, Long> {
	
	Casa findByCatastro(String catastro);
	Casa findByHabitaciones(Integer habitaciones);
	Casa findById(long id);
	Casa findByLocalidad(String localidad);

}