package com.example.RestGestionPedidos.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private LocalDate fecha;

    @ManyToOne
    private Cliente cliente; // Una orden pertenece a un cliente

    private String estado;   // "pendiente", "enviado", "cancelado", etc

}
