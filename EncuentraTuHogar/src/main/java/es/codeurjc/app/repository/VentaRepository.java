package es.codeurjc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.app.entity.Casa;
import es.codeurjc.app.entity.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {

	Venta findByCasa(Casa casa);


}
