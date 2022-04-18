package es.codeurjc.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.app.entity.Anuncio;
import es.codeurjc.app.entity.Casa;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

//Repositorio Anuncio que extiende de JPA
//JPA nos permite lanzar consultas sobre esta entidad
	
	Anuncio save(Anuncio anuncio);
	Anuncio findByNombre(String nombre);
	Anuncio findById(long id);
	Anuncio findByAsunto(String asunto);
	Anuncio findByNombreAndAsunto(String nombre, String asunto);
	Anuncio findByCasa(Casa casa);
	Page<Anuncio> findAll(Pageable page); //Devolver los resultados de las consultas paginados


}
