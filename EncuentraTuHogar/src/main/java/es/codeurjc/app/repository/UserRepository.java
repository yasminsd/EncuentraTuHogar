package es.codeurjc.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.app.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByName(String name);

}
