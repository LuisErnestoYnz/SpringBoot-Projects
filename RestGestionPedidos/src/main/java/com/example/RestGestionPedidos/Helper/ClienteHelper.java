package com.example.RestGestionPedidos.Helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteHelper {
    // Atributos que queremos a entity (se agrega dirección)
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
}
