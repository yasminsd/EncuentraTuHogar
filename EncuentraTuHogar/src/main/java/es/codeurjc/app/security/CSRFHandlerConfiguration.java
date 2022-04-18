package es.codeurjc.app.security;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/* Protección contra ataques de tipo CSRF (Cross‐site Request Forgery) 
 El método utilizado para protegernos de los ataques CSRF es definir un token que será 
 sincronizado con la sesión actual, cuando se intente ejecutar una petición Spring Security 
 comprobará si se trata de un token válido, si no lo es impide la ejecución de la petición, 
 de este modo un atacante no podrá enviar peticiones maliciosas ya que no conoce el token csrf.
 */

@Configuration
public class CSRFHandlerConfiguration implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CSRFHandlerInterceptor());
	}
}

class CSRFHandlerInterceptor implements HandlerInterceptor {

	@Override
	public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler,
			final ModelAndView modelAndView) throws Exception {

		if (modelAndView != null) {

			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			if (token != null) {
				modelAndView.addObject("token", token.getToken());
			}
		}
	}
}