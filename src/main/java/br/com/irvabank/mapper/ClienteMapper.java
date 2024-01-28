package br.com.irvabank.mapper;

import br.com.irvabank.dto.ClienteDTO;
import br.com.irvabank.model.ClienteEntity;

public class ClienteMapper {
    public static ClienteEntity dtoToEntity(ClienteDTO clienteDTO) {
        ClienteEntity cliente = new ClienteEntity();
        cliente.setNome(clienteDTO.getNome());
        cliente.setNumeroConta(clienteDTO.getNumeroConta());
        cliente.setActive(true);
        return cliente;
    }
}
