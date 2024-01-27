package br.com.irvabank.service;

import br.com.irvabank.dto.TransferenciaDTO;
import br.com.irvabank.exception.ApiException;
import br.com.irvabank.model.TransferenciaEntity;
import br.com.irvabank.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaService implements IService<TransferenciaDTO, TransferenciaEntity> {

    @Autowired
    private TransferenciaRepository repository;

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
        return repository.findAll(paging);
    }
}
