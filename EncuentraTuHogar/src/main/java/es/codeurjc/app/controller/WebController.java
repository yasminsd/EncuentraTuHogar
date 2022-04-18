package es.codeurjc.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.codeurjc.app.repository.AnuncioRepository;
import es.codeurjc.app.repository.CasaRepository;
import es.codeurjc.app.repository.CompraRepository;
import es.codeurjc.app.repository.UserRepository;
import es.codeurjc.app.repository.VentaRepository;

@Controller
public class WebController{
	@Autowired
	private AnuncioRepository repository;
    
	@Autowired
	private CasaRepository casaRepository;
	
	@Autowired
	private UserRepository usuarioRepository;
	
	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private VentaRepository ventaRepository;

	
	

	@GetMapping("/login")
    public String login() {
    	return "login";
    }
	
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
		
    	//String name = request.getUserPrincipal().getName();
    	model.addAttribute("administrador", request.isUserInRole("ADMIN"));
    	model.addAttribute("anuncios", repository.findAll(page));
    	//model.addAttribute("usuarios", usuarioRepository.findAll(page));
		model.addAttribute("anunciosCount", repository.count());
		model.addAttribute("usuariosCount", usuarioRepository.count());
		//model.addAttribute("usuarios",usuarioRepository.findByEmail(name));
		model.addAttribute("casas", casaRepository.count());
		model.addAttribute("Compra", compraRepository.count());
		model.addAttribute("venta", ventaRepository.count());
		return "administrador";
	
	}
}
