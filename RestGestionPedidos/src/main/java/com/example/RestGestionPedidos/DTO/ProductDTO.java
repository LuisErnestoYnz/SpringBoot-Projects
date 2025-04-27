package com.example.RestGestionPedidos.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    // Atributos que queremos regresar (se omitió el id)
    private String nombre;
    private double precio;
    private String descripcion;
}
