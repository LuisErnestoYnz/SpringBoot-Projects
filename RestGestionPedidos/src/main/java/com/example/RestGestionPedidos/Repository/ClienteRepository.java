package com.example.RestGestionPedidos.Repository;

import com.example.RestGestionPedidos.Entity.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public class ClienteRepository {
    private final ArrayList<Cliente> clientes = new ArrayList<>();
    // Se simula la autogeneración del id con esta propiedad.
    private int nextId;

    public ClienteRepository() {
        //Se agregan Clientes al ArrayList para que cada que la aplicación inicie estén estos datos
        clientes.add(new Cliente(1, "Luis Fernandez", "luis@gmail.com", "5518838558", "Av. cerro del agua, N. 21"));
        clientes.add(new Cliente(2, "Ana Martinez", "amartinez@gmail.com", "5523894435", "Calle Naranjo, N. 10"));
    }

    // Lee todos los clientes (GET)
    public ArrayList<Cliente> findAll(){
        return clientes;
    }

    // Lee cliente por id (GET)
    public Optional<Cliente> getClienteById(int id) {
        return clientes.stream().filter(cliente -> cliente.getId() == id).findFirst();
    }

    // Escribe un cliente (POST)
    public Cliente saveCliente(Cliente cliente) {
        nextId = clientes.size() + 1;
        cliente.setId(nextId);
        clientes.add(cliente);
        return cliente;
    }

    // Borrar un cliente por Id (DELETE)
    public void deleteClienteById(int id) {
        clientes.removeIf(cliente -> cliente.getId() == id);
    }

    // Actualiza un cliente por Id
    public Optional<Cliente> updateClienteById(int id, Cliente clienteActualizado) {
        return getClienteById(id).map(clienteExistente -> {
            clienteExistente.setNombre(clienteActualizado.getNombre());
            clienteExistente.setEmail(clienteActualizado.getEmail());
            clienteExistente.setTelefono(clienteActualizado.getTelefono());
            clienteExistente.setDireccion(clienteActualizado.getDireccion());
            return clienteExistente;
        });
    }

}
