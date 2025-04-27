package com.example.RestGestionPedidos.Service;

import com.example.RestGestionPedidos.DTO.ClienteDTO;
import com.example.RestGestionPedidos.Entity.Cliente;
import com.example.RestGestionPedidos.Helper.ClienteHelper;
import com.example.RestGestionPedidos.Mapper.ClienteMapper;
import com.example.RestGestionPedidos.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClienteServiceImpl implements IClienteService {
    //Para inyección de dependencias
    private ClienteRepository clienteRepository;
    //Para inyección de dependencias
    private ClienteMapper mapper;

    @Autowired        // No es necesario poner la anotación por tener 1 solo constructor
    public ClienteServiceImpl(ClienteRepository clienteRepository, ClienteMapper mapper) {
        this.clienteRepository = clienteRepository;
        this.mapper = mapper;
    }

    // GET obtener todos los clientes
    @Override
    public ArrayList<ClienteDTO> getAllClientes() {
        // Recibe Arraylist de Clientes, para luego en el foreach convertirla a ClienteDTO
        ArrayList<Cliente> clientesList = clienteRepository.findAll();
        // Creamos una ArrayList de ClientesDTO (guardará aquí los convertidos de Cliente a ClienteDTO)
        ArrayList<ClienteDTO> dtoListClientes = new ArrayList<>();
        // Conversion de Clientes a ClientesDTO
        for(Cliente cliente : clientesList) {
            ClienteDTO clienteDTO = mapper.toClienteDTO(cliente);
            dtoListClientes.add(clienteDTO);
        }
        // Se regresa la lista de ClientesDTO
        return dtoListClientes;
    }

    // GET obtener cliente por id
    @Override
    public ClienteDTO getCliente(int id) {
        // Se guarda en una referencia a Cliente
        Cliente cliente = clienteRepository.getClienteById(id).orElseThrow(() -> new RuntimeException("Cliente Not found"));
        // Se realiza la conversión de Cliente a ClienteDTO
        ClienteDTO clienteDTO = mapper.toClienteDTO(cliente);
        return clienteDTO;
    }

    // POST guardar clientes en Arraylist
    @Override
    public Cliente createCliente(ClienteHelper clienteHelper) {
        Cliente cliente = mapper.toCliente(clienteHelper);
        return clienteRepository.saveCliente(cliente);
    }

    // DELETE borrar clente de ArrayList
    @Override
    public void deleteCliente(int id) {
        clienteRepository.deleteClienteById(id);
    }

    // UPDATE actualizar cliente
    @Override
    public Cliente updateCliente(int id, Cliente clienteActualizado) {
        return clienteRepository.updateClienteById(id, clienteActualizado)
                .orElseThrow(() -> new RuntimeException("No se pudo actualizar porque no se encontró al Cliente con ID: " + id));
    }
}
