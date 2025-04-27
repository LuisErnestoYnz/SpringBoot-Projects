package com.example.RestGestionPedidos.Controller;

import com.example.RestGestionPedidos.DTO.ClienteDTO;
import com.example.RestGestionPedidos.Entity.Cliente;
import com.example.RestGestionPedidos.Helper.ClienteHelper;
import com.example.RestGestionPedidos.Service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteServiceImpl clienteServiceImpl;

    @Autowired      // No es necesario poner la anotación por tener 1 solo constructor
    public ClienteController(ClienteServiceImpl clienteServiceImpl) {
        this.clienteServiceImpl = clienteServiceImpl;
    }

    @GetMapping()
    public ResponseEntity<ArrayList<ClienteDTO>> getAllClientes(){
        return ResponseEntity.ok(clienteServiceImpl.getAllClientes());
    }

    @GetMapping("/{id}")
    public ClienteDTO getClienteById(@PathVariable int id) {
        return clienteServiceImpl.getCliente(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> createCliente(@RequestBody ClienteHelper clienteHelper) {
        return ResponseEntity.ok(clienteServiceImpl.createCliente(clienteHelper));
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable int id) {
        clienteServiceImpl.deleteCliente(id);
    }

    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable int id, @RequestBody Cliente clienteActualizado) {
        return clienteServiceImpl.updateCliente(id, clienteActualizado);
    }
}
