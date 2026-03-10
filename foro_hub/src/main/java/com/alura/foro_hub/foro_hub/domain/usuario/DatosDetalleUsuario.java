package com.alura.foro_hub.foro_hub.domain.usuario;

import com.alura.foro_hub.foro_hub.domain.direccion.DatosDireccion;
import com.alura.foro_hub.foro_hub.domain.direccion.Direccion;
import jakarta.validation.constraints.NotBlank;

public record DatosDetalleUsuario(
        Long id,
        String nombre,
        String email,
        String telefono,
        String documento,
        Boolean activo,
        Cargo cargo,
        DatosDireccion direccion){




    public DatosDetalleUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getTelefono(),
                usuario.getDocumento(),
                usuario.getActivo(),
                usuario.getCargo(),
                new DatosDireccion(usuario.getDireccion())
        );
    }
}