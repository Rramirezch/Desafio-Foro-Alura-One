package com.alura_foro_hub.foro_hub.controller;

import com.alura_foro_hub.foro_hub.usuario.DatosRegistroUsuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @PostMapping
    public void registrar(@RequestBody DatosRegistroUsuario datos){
        System.out.println(datos);

    }
}
