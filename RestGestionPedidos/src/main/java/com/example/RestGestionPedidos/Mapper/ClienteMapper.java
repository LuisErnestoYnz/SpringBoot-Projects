package com.example.RestGestionPedidos.Mapper;

import com.example.RestGestionPedidos.DTO.ClienteDTO;
import com.example.RestGestionPedidos.Entity.Cliente;
import com.example.RestGestionPedidos.Helper.ClienteHelper;
import org.springframework.stereotype.Component;

@Component      // Ya que generaremos un nuevo bean
public class ClienteMapper {
    //Se requiere regresar al cliente un ClienteDTO (Cliente -> ClienteDTO)
    public ClienteDTO toClienteDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        // Settear la información de la Entity Cliente (excepto el id y dirección)
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setEmail(cliente.getEmail());
        clienteDTO.setTelefono(cliente.getTelefono());
        return clienteDTO;
    }

    //Se requiere regresar al cliente un Cliente (ClienteDTO -> Cliente)
    public Cliente toCliente(ClienteHelper clienteHelper) {
        Cliente cliente = new Cliente();
        // Settear la información de la Entity ClienteHelper (excepto el id y dirección)
        cliente.setNombre(clienteHelper.getNombre());
        cliente.setEmail(clienteHelper.getEmail());
        cliente.setTelefono(clienteHelper.getTelefono());
        cliente.setDireccion(clienteHelper.getDireccion());
        return cliente;
    }
}
