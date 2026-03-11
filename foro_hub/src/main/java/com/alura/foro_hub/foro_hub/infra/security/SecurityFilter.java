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
    private TokenService tokenService;

    @Autowired
    private RegistroRepository registroRepository;



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        var tokenJWT = recuperarToken(request);
        if(tokenJWT != null){
            var subject = tokenService.getSubject(tokenJWT);
            var registro = registroRepository.findByLogin(subject);
            System.out.println(subject);

            var authentication = new UsernamePasswordAuthenticationToken(registro, null, registro.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("usuario logueado");
        }
        System.out.println("se llamo el filter");
        filterChain.doFilter(request, response);

    }
    private String recuperarToken(HttpServletRequest request){
        var authorizacionHeader = request.getHeader("Authorization");
        if(authorizacionHeader != null){
            return authorizacionHeader.replace("Bearer ", "");
        }
        return null;

    }


}
