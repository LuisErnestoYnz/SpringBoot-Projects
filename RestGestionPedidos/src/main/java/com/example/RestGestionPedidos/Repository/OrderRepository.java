package com.example.RestGestionPedidos.Repository;

import com.example.RestGestionPedidos.Entity.Cliente;
import com.example.RestGestionPedidos.Entity.Order;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class OrderRepository {
    private final ArrayList<Order> orders = new ArrayList<>();
    // Se simula la autogeneración del id con esta propiedad.
    private int nextId;

    public OrderRepository() {
        //Se agregan Orders al ArrayList para que cada que la aplicación inicie estén estos datos
        orders.add(new Order(1, LocalDate.of(2025,04,11), new Cliente(1, "Luis Fernandez", "luis@gmail.com", "5518838558", "Av. cerro del agua, N. 21"), "Enviado"));
        orders.add(new Order(2, LocalDate.of(2025,02,17), new Cliente(1, "Alejandra Garcia", "agarcia@gmail.com", "5511121314", "Av. independencia, N. 10"), "Cancelado"));
    }

    // Lee todos los order (GET)
    public ArrayList<Order> findAll(){
        return orders;
    }

    // Lee order por id (GET)
    public Optional<Order> getOrderById(int id) {
        return orders.stream().filter(order -> order.getId() == id).findFirst();
    }

    // Escribe un order (POST)
    public Order saveOrder(Order order) {
        nextId = orders.size() + 1;
        order.setId(nextId);
        orders.add(order);
        return order;
    }

    // Borrar un order por Id (DELETE)
    public void deleteOrderById(int id) {
        orders.removeIf(order -> order.getId() == id);
    }

    // Actualiza un order por Id
    public Optional<Order> updateOrderById(int id, Order ordenActualizada) {
        return getOrderById(id).map(ordenExistente -> {
            ordenExistente.setFecha(ordenActualizada.getFecha());
            ordenExistente.setCliente(ordenActualizada.getCliente());
            ordenExistente.setEstado(ordenActualizada.getEstado());
            return ordenExistente;
        });
    }
}
