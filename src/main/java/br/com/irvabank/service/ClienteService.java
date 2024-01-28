package br.com.irvabank.service;

import br.com.irvabank.dto.ClienteDTO;
import br.com.irvabank.exception.ApiException;
import br.com.irvabank.mapper.ClienteMapper;
import br.com.irvabank.model.ClienteEntity;
import br.com.irvabank.model.TransferenciaEntity;
import br.com.irvabank.repository.ClienteRepository;
import br.com.irvabank.validation.ClienteCadastroValidation;
import br.com.irvabank.validation.ClienteEdicaoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService implements IService<ClienteDTO, ClienteEntity> {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteCadastroValidation clienteCadastroValidation;

    @Autowired
    private ClienteEdicaoValidation clienteEdicaoValidation;

    @Override
    public ClienteEntity insert(ClienteDTO clienteDTO) throws ApiException {
        ClienteEntity cliente = ClienteMapper.dtoToEntity(clienteDTO);

        validarErrosCadastro(cliente);

        return repository.save(cliente);
    }

    private void validarErrosCadastro(ClienteEntity cliente) {
        Errors errors = new BeanPropertyBindingResult(cliente, ClienteEntity.class.getName());

        clienteCadastroValidation.validate(cliente, errors);

        if (errors.hasErrors()) {
            List<String> errorMessages = errors.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.toList());

            throw new ApiException(401, String.join(" ", errorMessages));
        }
    }

    @Override
    public ClienteEntity update(ClienteDTO dto) throws ApiException {

        validarErrosEdicao(dto);

        ClienteEntity cliente = ClienteMapper.dtoToEntity(dto);
        cliente.setId(dto.getId());

        return repository.save(cliente);
    }

    private void validarErrosEdicao(ClienteDTO dto) {
        Errors errors = new BeanPropertyBindingResult(dto, ClienteDTO.class.getName());

        clienteEdicaoValidation.validate(dto, errors);

        if (errors.hasErrors()) {
            List<String> errorMessages = errors.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.toList());

            throw new ApiException(401, String.join(" ", errorMessages));
        }
    }

    @Override
    public ClienteEntity getById(Integer id) throws ApiException {
        Optional<ClienteEntity> optional = repository.findById(id);

        if(optional.isPresent()) {
            return optional.get();
        }else {
            throw new ApiException(401, "Cliente nao encontrado");
        }
    }

    @Override
    public ClienteEntity delete(Integer id) throws ApiException {
        ClienteEntity entity = getById(id);
        repository.delete(entity);
        return null;
    }

    @Override
    public ClienteEntity activate(Integer id) throws ApiException {
        ClienteEntity entity = getById(id);
        entity.setActive(false);
        return repository.save(entity);
    }

    @Override
    public Page<ClienteEntity> findAll(Pageable paging) throws ApiException {
        return repository.findAll(paging);
    }
}
