package com.alura.foro_hub.foro_hub.infra.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarContrasenas {


    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Para una contraseña específica
        String contrasenaPlana = "123456";
        String contrasenaEncriptada = encoder.encode(contrasenaPlana);
        System.out.println("Contraseña encriptada: " + contrasenaEncriptada);

        // Esto producirá algo como: $2a$10$XURPShQ7s8mYOEpHZOMd7eHDr9QH0H.6KxnQ2L.cK9gF5KqQ5XqG
    }

}
