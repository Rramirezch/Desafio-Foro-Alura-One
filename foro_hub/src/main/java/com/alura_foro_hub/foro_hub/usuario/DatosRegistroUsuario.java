package com.alura_foro_hub.foro_hub.usuario;

import com.alura_foro_hub.foro_hub.direccion.Direccion;

public record DatosRegistroUsuario(
        String nombre,
        String email,
        String telefono,
        String documenteo,
        Cargo cargo,
        Direccion direccion
) {
}
