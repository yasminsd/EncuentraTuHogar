package es.codeurjc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.app.entity.Anuncio;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

}
