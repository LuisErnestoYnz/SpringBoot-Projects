package com.example.RestGestionPedidos.Service;

import com.example.RestGestionPedidos.DTO.ClienteDTO;
import com.example.RestGestionPedidos.Entity.Cliente;
import com.example.RestGestionPedidos.Helper.ClienteHelper;

import java.util.ArrayList;

public interface IClienteService {
    // GET obtener todos los clientes
    ArrayList<ClienteDTO> getAllClientes();
    // GET obtener cliente por id
    ClienteDTO getCliente(int id);
    // POST guardar clientes en Arraylist
    Cliente createCliente(ClienteHelper clienteHelper);
    // DELETE borrar clente de ArrayList
    void deleteCliente(int id);
    // UPDATE actualizar cliente
    Cliente updateCliente(int id, Cliente clienteActualizado);
}
