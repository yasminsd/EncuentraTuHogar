package es.codeurjc.app.service;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.codeurjc.app.entity.Anuncio;
import es.codeurjc.app.entity.Casa;
import es.codeurjc.app.entity.Compra;
import es.codeurjc.app.entity.User;
import es.codeurjc.app.entity.Venta;
import es.codeurjc.app.repository.AnuncioRepository;
import es.codeurjc.app.repository.CasaRepository;
import es.codeurjc.app.repository.CompraRepository;
import es.codeurjc.app.repository.UserRepository;
import es.codeurjc.app.repository.VentaRepository;

	@Controller
	public class TablonController {

		@Autowired
		private AnuncioRepository anuncioRepository;
		
		@Autowired
		private CasaRepository casaRepository;
		
		@Autowired
		private UserRepository usuarioRepository;
		
		@Autowired
		private CompraRepository compraRepository;
		
		@Autowired
		private VentaRepository ventaRepository;

		@PostConstruct
		public void init() {
			
			//Insertamos un administrador y cuatro usuarios
			
			User u1 = new User("user","pass","03122836B","user@user.com","ROLE_USER");
			User u2 = new User("jrperez","jrperezpass","25786524L","jrperez@gmail.com","ROLE_USER");
			User u3 = new User("ammartin","ammpass","98736485O","amm@yahoo.com","ROLE_USER"); 
			User u4 = new User("admin","adminpass","55555566N","admin@admin.com","ROLE_USER", "ROLE_ADMIN");
			User u5 = new User("egcuevas","egcuevaspass","58742695Y","egcuevas@msn.com","ROLE_USER");
			
		
			/*Insertamos 2 casas*/
			
			Casa c1 = new Casa("HRU456JD7U",6 , 450.50, 2010, "Sevilla", 450000.0, u5);
			Casa c2 = new Casa("HYTECJDTWO",5 , 325.25, 2005, "Burgos", 300000.0, u2);
			
			
			/*Persisto usuarios*/
		
			usuarioRepository.save(u1);
			usuarioRepository.save(u2);
			usuarioRepository.save(u3);
			usuarioRepository.save(u4);
			usuarioRepository.save(u5);
			
	        /*Persisto casas */
			
			casaRepository.save(c1);
			casaRepository.save(c2);
			
			/*Creamos anuncios y los asignamos a los usuarios*/
			
			Anuncio a1 = new Anuncio("Casa con encanto", "No dejes pasar esta oportunidad");
			Anuncio a2 = new Anuncio("Casa de ensueño", "Para entrar a vivir");
			a1.setUsuario(u1);
			a2.setUsuario(u2);
			a1.setCasa(c1);
			a2.setCasa(c2);
			
			/*Creamor una oferta de compra */
			
			Compra comp1 = new Compra("29/03/2022", 400.000);
			comp1.setCasa(c1);
			comp1.setComprador(u1);
			comp1.setVendedor(c1.getPropietario());
			
			compraRepository.save(comp1);
			
			//Creamos Oferta
			
			Compra comp2 = new Compra("30/03/2022", 295.000);
			comp2.setCasa(c2);
			comp2.setComprador(u2);
			comp2.setVendedor(c2.getPropietario());
			
			compraRepository.save(comp2);
			
			//Guardamos los anuncios p1,p2,p3
			anuncioRepository.save(a1);
			anuncioRepository.save(a2);
			
		}
		

		@RequestMapping("/")
		public String tablon(Model model, Pageable page, HttpServletRequest request) {

			model.addAttribute("anuncios", anuncioRepository.findAll(page));
			model.addAttribute("usuarios", usuarioRepository.findAll(page));
			model.addAttribute("usuariosCounter", usuarioRepository.count());
			model.addAttribute("casas", casaRepository.count());
			model.addAttribute("Compra", compraRepository.count());
			model.addAttribute("venta", ventaRepository.count());
			model.addAttribute("user", request.isUserInRole("USER"));
			model.addAttribute("administrador", request.isUserInRole("ADMIN"));
			
			return "principal";
		}
		
	  
		
		@RequestMapping("/ver_ofertas")
		public String tablon(Model model,HttpServletRequest request) {
			String nombre = request.getUserPrincipal().getName();
			User u = usuarioRepository.findByName(nombre);
			model.addAttribute("ofertas", compraRepository.findByVendedor(u));
			
			return "ver_ofertas";
		}

		@RequestMapping("/anuncio/new")
		public String nuevoAnuncio(Model model, @RequestParam String nombre, 
				//Parámetro con el valor del campo de texto del formulario
				@RequestParam String asunto,@RequestParam String catastro,
				@RequestParam int habitaciones,
				@RequestParam double metros,@RequestParam int anioConstruccion,
				@RequestParam String localidad, 
				@RequestParam double precio,HttpServletRequest request) {

			User u = usuarioRepository.findByName(request.getUserPrincipal().getName());
			
			
			
			Casa c = new Casa(catastro, habitaciones, metros, anioConstruccion, localidad, precio, u);
			casaRepository.save(c);
			
			Anuncio a = new Anuncio(nombre,asunto);
			
			a.setCasa(c);
			a.setUsuario(u);
			
			anuncioRepository.save(a);
			
			return "anuncio_saved";

		}
		
		
		@RequestMapping("/usuario/new")
		public String nuevoUsuario(Model model,@RequestParam String name,@RequestParam String password,  
				@RequestParam String dni,@RequestParam String email, HttpServletRequest request) {

			if(request.isUserInRole("ADMIN")){
				model.addAttribute("admin", request.isUserInRole("ADMIN"));
			User u = new User(name,password,dni,email,"ROLE_USER"," ROLE_ADMIN");
			usuarioRepository.save(u);
			return "usuario_saved";
					}
			
			else {
				User u = new User(name,password,dni,email,"ROLE_USER");
				usuarioRepository.save(u);	
				return "usuario_saved";
			}
			
	}		
		
		
		
		@RequestMapping("/anuncio/{id}")
		public String verAnuncio(Model model, @PathVariable long id) {
			
			//Con @PathVarible, la información también se pueden incluir como 
			//parte de la propia URL, en vez de cómo parámetros
			
			Anuncio anuncio = anuncioRepository.findById(id);
			Casa casa = anuncio.getCasa();
			model.addAttribute("anuncio", anuncio);
			model.addAttribute("casa", casa);
			return "ver_anuncio";
		}
		
		@RequestMapping("/usuario/{id}")
        public String verUsuario(Model model, @PathVariable long id) {
			
			User usuario = usuarioRepository.findById(id);
			model.addAttribute("usuarios", usuario);
			
			return "ver_usuario";
		}
		
		@RequestMapping(value="/usuario/lista", method=RequestMethod.GET)
        public String listaUsuario(Model model, Pageable page, HttpServletRequest request) {
			
			model.addAttribute("usuarios", usuarioRepository.findAll(page));

			return "listaUsuarios";
		}
		
		
		
		
		@RequestMapping("/vender")
		public String comprar(Model model,@RequestParam long idc,@RequestParam long ido) {
			
			Compra ofe = compraRepository.findById(ido);
			Casa casa = casaRepository.findById(idc);
			List<Compra> lista = compraRepository.findByCasa(casa);
			
			//Registramos venta
			Venta venta = new Venta(ofe.getFechaOferta(),ofe.getPrecioOferta());
			venta.setCasa(casa);
			venta.setComprador(ofe.getComprador());
			venta.setVendedor(casa.getPropietario());			
			ventaRepository.save(venta);
			
			//Borramos Anuncio
			Anuncio anu = anuncioRepository.findByCasa(casa);
			anuncioRepository.deleteById(anu.getId());
			
			//Borramos Ofertas
			for(Compra str : lista)
				{
					compraRepository.delete(str);
				}
			
			return "venta_realizada";
		}
		
		
		@RequestMapping("/anuncio/oferta")
		public String nuevosAnuncio(Model model, @RequestParam String fechaOferta, 
				@RequestParam double precioOferta, @RequestParam long id,
				HttpServletRequest request ) {

			Compra ofer = new Compra(fechaOferta, precioOferta);
			Casa casa3 = casaRepository.findById(id);
			
			ofer.setCasa(casa3);
			ofer.setComprador(usuarioRepository.findByName(request.getUserPrincipal().getName()));
			ofer.setVendedor(casa3.getPropietario());
			casa3.setPropietario(usuarioRepository.findByName(request.getUserPrincipal().getName()));
			casa3.setPrecio(precioOferta);
			compraRepository.save(ofer);

			model.addAttribute("casa", casa3);
			
			return "oferta_realizada";

		}
		
	
		
		@RequestMapping(value="/delete/usuario", method=RequestMethod.POST)
		public String eliminarUsuario (Model model,  @RequestParam (value="dni")
			String dni, Pageable page)
		{
			List<User> user = usuarioRepository.findByDni(dni);
			model.addAttribute("usuarios", usuarioRepository.findAll(page));
			model.addAttribute("user", user);

			usuarioRepository.deleteAll(user);
				
			
			return "usuario_deleted";
		}
		
			
		@RequestMapping(value="/delete/anuncio", method=RequestMethod.POST)
		public String eliminaAnuncio(Model model, @RequestParam (value="catastro") String catastro)
		{
			Casa co = casaRepository.findByCatastro(catastro);
			Anuncio anu = anuncioRepository.findByCasa(co);	
			
			anuncioRepository.deleteById(anu.getId());

			return "anuncio_eliminado";
			
		}	
	
}
	


