package br.com.irvabank.service;

import br.com.irvabank.dto.TransferenciaDTO;
import br.com.irvabank.exception.ApiException;
import br.com.irvabank.model.ClienteEntity;
import br.com.irvabank.model.TransferenciaEntity;
import br.com.irvabank.repository.ClienteRepository;
import br.com.irvabank.repository.TransferenciaRepository;
import br.com.irvabank.util.TaxaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

@Service
public class TransferenciaService implements IService<TransferenciaDTO, TransferenciaEntity> {

    @Autowired
    private TransferenciaRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public TransferenciaEntity insert(TransferenciaDTO dto) throws ApiException {

        ClienteEntity clienteDestino = clienteRepository.findByNumeroConta(dto.getContaDestino());
        ClienteEntity clienteOrigem = clienteRepository.findByNumeroConta(dto.getContaOrigem());

        TransferenciaEntity entity = new TransferenciaEntity();
        entity.setContaOrigem(dto.getContaOrigem());
        entity.setContaDestino(dto.getContaDestino());
        entity.setDataTransferencia(dto.getDataTransferencia());
        entity.setValor(dto.getValor());
        entity.setCliente(clienteOrigem);
        entity.setDataAgendamento(Timestamp.from(Instant.now()));
        entity.setTaxa(TaxaUtil.calcularValorTaxa(entity.getValor(), entity.getDataTransferencia(), entity.getDataAgendamento()));
        entity = repository.save(entity);
        return entity;
    }

    @Override
    public TransferenciaEntity update(TransferenciaDTO transferenciaDTO) throws ApiException {
        return null;
    }

    @Override
    public TransferenciaEntity getById(Integer id) throws ApiException {
        Optional<TransferenciaEntity> optional = repository.findById(id);

        if(optional.isPresent()) {
            return optional.get();
        }else {
            throw new ApiException(401, "Transferencia nao encontrado");
        }
    }

    @Override
    public TransferenciaEntity delete(Integer id) throws ApiException {
        TransferenciaEntity entity = getById(id);
        repository.delete(entity);
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
