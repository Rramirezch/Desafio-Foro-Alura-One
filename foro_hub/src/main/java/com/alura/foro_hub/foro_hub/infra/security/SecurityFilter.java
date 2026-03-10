package com.alura.foro_hub.foro_hub.infra.security;

import com.alura.foro_hub.foro_hub.domain.registro.Registro;
import com.alura.foro_hub.foro_hub.domain.registro.RegistroRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private RegistroRepository registroRepository;

    @Autowired
    private TokenService tokenService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String path = request.getRequestURI();
        System.out.println("FILTRO LLAMADO - Path: " + request.getRequestURI());
        // Si es una ruta pública, continua sin verificar token
        if (path.equals("/login") || path.equals("/registro")) {
            System.out.println("Ruta pública, continuando sin token");
            filterChain.doFilter(request, response);
            return;
        }

        System.out.println("se llamo el filter");
        var tokenJWT = recuperarToken(request);
        System.out.println(tokenJWT);
        // Obtener el token del header
        /*var authHeader = request.getHeader("Authorization");
        if (authHeader != null) {
            var token = authHeader.replace("Bearer ", "");
            var nombreUsuario = tokenService.getSubject(token); // extract username
            if (nombreUsuario != null) {
                // Token valido
                var registro = registroRepository.findByLogin((nombreUsuario));
                var authentication = new UsernamePasswordAuthenticationToken(registro, null,
                        registro.getAuthorities()); // Forzamos un inicio de sesion
                SecurityContextHolder.getContext().setAuthentication(authentication);
                System.out.println(token);
            }
        }*/
        filterChain.doFilter(request, response);
    }
    private String recuperarToken(HttpServletRequest request){
        var autorizacionHeader = request.getHeader("Authorization");
        if(autorizacionHeader == null){
            throw new RuntimeException(("token no encviado en el encabezado"));
        }
        return autorizacionHeader;
    }
}
