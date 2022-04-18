package es.codeurjc.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public UserRepositoryAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
    	// Public pages
    	http.authorizeRequests().antMatchers("/").permitAll();
    	http.authorizeRequests().antMatchers("/newUsuario").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
                   
        http.authorizeRequests().antMatchers("/bienvenidalogin").permitAll();
        http.authorizeRequests().antMatchers("/logout").permitAll();
        http.authorizeRequests().antMatchers("/ver_ofertas").permitAll();
        http.authorizeRequests().antMatchers("/errorlogin").permitAll();

        // Private pages (all other pages) para los usuarios
        http.authorizeRequests().antMatchers("/newAnuncio").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/oferta").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/anuncio/{id}").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/usuario/{id}").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/verofertas").hasAnyRole("USER");
        
        //Exclusivas del Admin
        http.authorizeRequests().antMatchers("/administrador").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/delete/usuario").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/deleteUsuario/*").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/listaUsuarios").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/listaUsuarios/*").hasAnyRole("ADMIN");
      
        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/bienvenidalogin");     
        http.formLogin().failureUrl("/errorlogin");

        // Logout
        //http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/logout");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        // Database authentication provider
        auth.authenticationProvider(authenticationProvider);
    }

}
