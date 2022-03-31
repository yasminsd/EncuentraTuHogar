package es.codeurjc.app.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import es.codeurjc.app.entity.Casa;
import es.codeurjc.app.entity.User;
import es.codeurjc.app.repository.CasaRepository;
import es.codeurjc.app.repository.UserRepository;

@Service
public class DatabaseInitializer {

	@Autowired
	private CasaRepository casaRepository;

	@Autowired
	private UserRepository userRepository;
	
	//@Autowired
	//private AnuncioRepository anuncioRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostConstruct
	public void init() {
		
		casaRepository.save(new Casa("HRU456JD7U",6 , 450.50, 2010, "Sevilla", 450000.0));
		casaRepository.save(new Casa("HYTECJDTWO",5 , 325.25, 2005, "Burgos", 300000.0));
		casaRepository.save(new Casa("JR73GGW357",4 , 300.75, 2001, "Guadalajara", 250000.0));
		casaRepository.save(new Casa("IRUSELK58Q",6 , 560.80, 2019, "Ibiza", 800000.0));
		casaRepository.save(new Casa("UEBDÑQ765L",5 , 390.15, 2008, "Segovia", 375000.0));
		

		userRepository.save(new User("user", passwordEncoder.encode("pass"), "USER"));
		userRepository.save(new User("admin", passwordEncoder.encode("adminpass"), "USER", "ADMIN"));
		
		//anuncioRepository.save(new Anuncio("Casa con encanto", "No dejes pasar esta oportunidad"));
		//anuncioRepository.save(new Anuncio("Casa de ensueño", "Para entrar a vivir"));
		
	}
}
