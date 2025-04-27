package com.example.RestGestionPedidos.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    // Atributos que queremos regresar (se omitió el id y dirección)
    private String nombre;
    private String email;
    private String telefono;
}
