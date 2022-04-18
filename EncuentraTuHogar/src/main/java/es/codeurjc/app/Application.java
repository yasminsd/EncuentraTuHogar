package es.codeurjc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

/*@SpringBootApplication es una anotación simplificada de la unificación de = 
(propiedad predeterminada) @Configuration + @EnableAutoConfiguration + @ComponentScan.
Se trata de la clase principal*/