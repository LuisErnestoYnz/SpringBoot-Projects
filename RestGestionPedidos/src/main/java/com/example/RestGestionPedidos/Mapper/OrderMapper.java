package com.example.RestGestionPedidos.Mapper;

import com.example.RestGestionPedidos.DTO.OrderDTO;
import com.example.RestGestionPedidos.Entity.Order;
import com.example.RestGestionPedidos.Helper.OrderHelper;
import org.springframework.stereotype.Component;

@Component    // Ya que generaremos un nuevo bean
public class OrderMapper {
    //Se requiere regresar al order un OrderDTO
    public OrderDTO toOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        // Settear la información de la Entity Order (excepto el id)
        orderDTO.setFecha(order.getFecha());
        orderDTO.setCliente(order.getCliente());
        orderDTO.setEstado(order.getEstado());
        return orderDTO;
    }

    //Se requiere regresar al orderDTO un Order (OrderDTO -> Order)
    public Order toOrder(OrderHelper orderHelper) {
        Order order = new Order();
        /// Settear la información de la Entity OrderHelper (excepto el id)
        order.setFecha(orderHelper.getFecha());
        order.setCliente(orderHelper.getCliente());
        order.setEstado(orderHelper.getEstado());
        return order;
    }
}
