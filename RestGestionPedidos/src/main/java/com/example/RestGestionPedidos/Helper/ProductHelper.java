package com.example.RestGestionPedidos.Helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductHelper {
    // Atributos que queremos regresar (se omitió el id)
    private String nombre;
    private double precio;
    private String descripcion;
}
