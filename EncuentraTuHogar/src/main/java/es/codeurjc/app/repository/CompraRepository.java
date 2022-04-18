package es.codeurjc.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.app.entity.Casa;
import es.codeurjc.app.entity.Compra;
import es.codeurjc.app.entity.User;

public interface CompraRepository extends JpaRepository<Compra, Long> {
	
	Compra findById(long id);
	
	List<Compra> findByfechaOferta(String fOferta);
	List<Compra> findByCasa(Casa casa);
	void deleteByCasa(Casa casa);
	Compra findByComprador(User comprador);
	List<Compra> findByVendedor(User vendedor);

}
