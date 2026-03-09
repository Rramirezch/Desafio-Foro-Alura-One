package com.alura.foro_hub.foro_hub.domain.registro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService implements UserDetailsService {
    @Autowired
    private RegistroRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
        // Buscar por login (que funciona como email)
        /*Registro registro = repository.findByLogin(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + email));

        return User.builder()
                .username(registro.getLogin())     // Usa login como username
                .password(registro.getContrasena()) // Usa contrasena como password
                .roles("USER")  // Asigna un rol por defecto
                .build();*/
    }

}