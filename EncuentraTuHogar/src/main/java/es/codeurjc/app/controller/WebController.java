package es.codeurjc.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.codeurjc.app.repository.AnuncioRepository;
import es.codeurjc.app.repository.CasaRepository;
import es.codeurjc.app.repository.CompraRepository;
import es.codeurjc.app.repository.UserRepository;
import es.codeurjc.app.repository.VentaRepository;

@Controller //Clase encargada de atender las peticiones web
public class WebController{
	
	@Autowired //Relación entre componentes dentro de un constructor. Inyección de dependencias
	private AnuncioRepository repository;
    
	@Autowired
	private CasaRepository casaRepository;
	
	@Autowired
	private UserRepository usuarioRepository;
	
	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private VentaRepository ventaRepository;

	
	

	@GetMapping("/login") //Solicitamos la URL "/login" y nos devolverá "login"
    public String login() {
    	return "login";
    }
	
	
	/* 
	Solicitamos la URL "/newUsuario" y nos devolverá "newUsuario"
	
	Recibe Model, HttpServletRequest y Pageable.
	La subclase HttpServletRequest procesa peticiones de tipo HTTP.
	Un objeto de tipo ServletRequest que contiene los datos 
	de la petición del usuario (toda la información entrante).
	Y Pageable incluye la información de ordenacion de la URL
	
	Y por último se añade al parámetro model la información que será visualizada
	en la página web
	
	*/
	
	@GetMapping("/newUsuario")
    public String getUsuario(Model model, HttpServletRequest request,Pageable page) {
		model.addAttribute("administrador", request.isUserInRole("ADMIN"));
    	return "newUsuario";
    }
    
	
	@GetMapping("/newAnuncio")
    public String getAnuncio(Model model, HttpServletRequest request, Pageable page) {
    	model.addAttribute("administrador", request.isUserInRole("ADMIN"));
		return "newAnuncio";
    }
	
	@GetMapping("/delete_anuncio")
    public String borrarAnuncio(Model model, HttpServletRequest request, Pageable page) {
    	model.addAttribute("administrador", request.isUserInRole("ADMIN"));
		return "delete_anuncio";
    }
	
	@GetMapping("/deleteUsuario")
    public String eliminarUsuario(Model model, HttpServletRequest request, Pageable page) {
    	model.addAttribute("administrador", request.isUserInRole("ADMIN"));
    	model.addAttribute("usuarios", usuarioRepository.findAll(page));
		return "deleteUsuario";
    }
	
	@GetMapping("/listaUsuarios")
    public String listaUsuarios(Model model, HttpServletRequest request, Pageable page) {
    	model.addAttribute("administrador", request.isUserInRole("ADMIN"));
    	model.addAttribute("usuarios", usuarioRepository.findAll(page));
		return "listaUsuarios";
    }
	

    @GetMapping("/errorlogin")
    public String loginerror() {
    	return "errorlogin";
    }

    @GetMapping("/bienvenidalogin")
    public String bienvenidalogin() {
    	return "bienvenidalogin";
    }
    
    @GetMapping("/logout")
    public String logout() {
    	return "logout";
    }
    
    
    
    @GetMapping("/administrador")
	public String index(Model model, HttpServletRequest request,Pageable page) { 
		
    	model.addAttribute("administrador", request.isUserInRole("ADMIN"));
    	model.addAttribute("anuncios", repository.findAll(page));
		model.addAttribute("anunciosCount", repository.count());
		model.addAttribute("usuariosCount", usuarioRepository.count());
		model.addAttribute("casas", casaRepository.count());
		model.addAttribute("Compra", compraRepository.count());
		model.addAttribute("venta", ventaRepository.count());
		return "administrador";
	
	}
}
