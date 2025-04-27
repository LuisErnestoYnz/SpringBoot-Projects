package com.example.RestGestionPedidos.Service;

import com.example.RestGestionPedidos.DTO.OrderDTO;
import com.example.RestGestionPedidos.Entity.Order;
import com.example.RestGestionPedidos.Helper.OrderHelper;

import java.util.ArrayList;

public interface IOrderService {
    // GET obtener todos los orders
    ArrayList<OrderDTO> getAllOrders();
    // GET obtener order por id
    OrderDTO getOrder(int id);
    // POST guardar orders en Arraylist
    Order createOrder(OrderHelper orderHelper);
    // DELETE borrar order de ArrayList
    void deleteOrder(int id);
    // UPDATE actualizar order
    Order updateOrder(int id, Order orderActualizado);
}
