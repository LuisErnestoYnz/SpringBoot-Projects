package com.example.RestGestionPedidos.Service;

import com.example.RestGestionPedidos.DTO.OrderDTO;
import com.example.RestGestionPedidos.Entity.Order;
import com.example.RestGestionPedidos.Helper.OrderHelper;
import com.example.RestGestionPedidos.Mapper.OrderMapper;
import com.example.RestGestionPedidos.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderServiceImpl implements IOrderService{
    //Para inyección de dependencias
    private OrderRepository orderRepository;
    //Para inyección de dependencias
    private OrderMapper mapper;

    // Constructor donde se le inyecta el bean de clienteRepository
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper mapper) {
        this.orderRepository = orderRepository;
        this.mapper = mapper;
    }

    // GET obtener todos los orders
    @Override
    public ArrayList<OrderDTO> getAllOrders() {
        // Recibe Arraylist de Orders, para luego en el foreach convertirla a OrderDTO
        ArrayList<Order> ordersList = orderRepository.findAll();
        // Creamos una ArrayList de OrdersDTO (guardará aquí los convertidos de Order a OrderDTO)
        ArrayList<OrderDTO> dtoListOrders = new ArrayList<>();
        // Conversion de Orders a OrdersDTO
        for(Order order : ordersList) {
            OrderDTO orderDTO = mapper.toOrderDTO(order);
            dtoListOrders.add(orderDTO);
        }
        // Se regresa la lista de OrdersDTO
        return dtoListOrders;
    }

    // GET obtener order por id
    @Override
    public OrderDTO getOrder(int id) {
        // Se guarda en una referencia a Order
        Order order = orderRepository.getOrderById(id).orElseThrow(() -> new RuntimeException("Order Not found"));
        // Se realiza la conversión de Order a OrderDTO
        OrderDTO orderDTO = mapper.toOrderDTO(order);
        return orderDTO;
    }

    // POST guardar orders en Arraylist
    @Override
    public Order createOrder(OrderHelper orderHelper) {
        Order order = mapper.toOrder(orderHelper);
        return orderRepository.saveOrder(order);
    }

    // DELETE borrar order de ArrayList
    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteOrderById(id);
    }

    // UPDATE actualizar order
    @Override
    public Order updateOrder(int id, Order orderActualizado) {
        return orderRepository.updateOrderById(id, orderActualizado)
                .orElseThrow(() -> new RuntimeException("No se pudo actualizar porque no se encontró al Order con ID: " + id));
    }
}
