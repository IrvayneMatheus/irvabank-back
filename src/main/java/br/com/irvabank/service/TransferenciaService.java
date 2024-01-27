package br.com.irvabank.service;

import br.com.irvabank.dto.TransferenciaDTO;
import br.com.irvabank.exception.ApiException;
import br.com.irvabank.model.TransferenciaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaService implements IService<TransferenciaDTO, TransferenciaEntity> {
    @Override
    public TransferenciaEntity insert(TransferenciaDTO transferenciaDTO) throws ApiException {
        return null;
    }

    @Override
    public TransferenciaEntity update(TransferenciaDTO transferenciaDTO) throws ApiException {
        return null;
    }

    @Override
    public TransferenciaEntity getById(Integer id) throws ApiException {
        return null;
    }

    @Override
    public TransferenciaEntity delete(Integer id) throws ApiException {
        return null;
    }

    @Override
    public TransferenciaEntity activate(Integer id) throws ApiException {
        return null;
    }

    @Override
    public Page<TransferenciaEntity> findAll(Pageable paging) throws ApiException {
        return null;
    }
}
