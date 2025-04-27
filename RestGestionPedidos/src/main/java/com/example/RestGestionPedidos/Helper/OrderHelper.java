package com.example.RestGestionPedidos.Helper;

import com.example.RestGestionPedidos.Entity.Cliente;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderHelper {
    // Atributos que queremos a entity (se omitió el id)
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;

    @ManyToOne
    private Cliente cliente; // Una orden pertenece a un cliente

    private String estado;   // "pendiente", "enviado", "cancelado", etc
}
