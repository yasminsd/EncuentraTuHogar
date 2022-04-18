package es.codeurjc.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.app.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findById(long id);
	User findByName(String name);
	User findByEmail (String email);
	
	List<User> findByDni(String dni);
	
	Page<User> findAll(Pageable page);

}
