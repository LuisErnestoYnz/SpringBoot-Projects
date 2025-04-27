package com.example.RestGestionPedidos.Controller;

import com.example.RestGestionPedidos.DTO.OrderDTO;
import com.example.RestGestionPedidos.Entity.Order;
import com.example.RestGestionPedidos.Helper.OrderHelper;
import com.example.RestGestionPedidos.Service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderServiceImpl orderServiceImpl;

    @Autowired      // No es necesario poner la anotación por tener 1 solo constructor
    public OrderController(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    @GetMapping()
    public ResponseEntity<ArrayList<OrderDTO>> getAllOrders(){
        return ResponseEntity.ok(orderServiceImpl.getAllOrders());
    }

    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable int id) {
        return orderServiceImpl.getOrder(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Order> createOrder(@RequestBody OrderHelper orderHelper) {
        return ResponseEntity.ok(orderServiceImpl.createOrder(orderHelper));
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderServiceImpl.deleteOrder(id);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable int id, @RequestBody Order orderActualizado) {
        return orderServiceImpl.updateOrder(id, orderActualizado);
    }

}
