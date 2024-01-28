package br.com.irvabank.validation;

import br.com.irvabank.dto.ClienteDTO;
import br.com.irvabank.model.ClienteEntity;
import br.com.irvabank.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
public class ClienteEdicaoValidation implements Validator {

    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public boolean supports(Class<?> clazz) {return ClienteDTO.class.equals(clazz);}

    @Override
    public void validate(Object target, Errors errors) {
        ClienteDTO dto = (ClienteDTO) target;

        boolean existeId = clienteRepository.existsById(dto.getId());

        ClienteEntity cliente = clienteRepository.findByNumeroConta(dto.getNumeroConta());

        if (cliente != null && (existeId && !Objects.equals(dto.getId(), cliente.getId()))) {
            errors.reject("Cadastro Inválido", "Não é possivel editar, pois esse número de conta já está sendo utilizado por outro cliente.");
        }
    }
}
