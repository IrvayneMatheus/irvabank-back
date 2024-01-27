package br.com.irvabank.service;

import br.com.irvabank.dto.ClienteDTO;
import br.com.irvabank.exception.ApiException;
import br.com.irvabank.model.ClienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IService<ClienteDTO, ClienteEntity> {
    @Override
    public ClienteEntity insert(ClienteDTO clienteDTO) throws ApiException {
        return null;
    }

    @Override
    public ClienteEntity update(ClienteDTO clienteDTO) throws ApiException {
        return null;
    }

    @Override
    public ClienteEntity getById(Integer id) throws ApiException {
        return null;
    }

    @Override
    public ClienteEntity delete(Integer id) throws ApiException {
        return null;
    }

    @Override
    public ClienteEntity activate(Integer id) throws ApiException {
        return null;
    }

    @Override
    public Page<ClienteEntity> findAll(Pageable paging) throws ApiException {
        return null;
    }
}
