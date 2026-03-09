package com.alura.foro_hub.foro_hub.domain.registro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;


public interface RegistroRepository extends JpaRepository<Registro, Long> {
    UserDetails findByLogin(String username);

    //UserDetails findBylogin(String login);
    //Optional<Registro> findByLogin(String login); // Buscar por login (email)
}
