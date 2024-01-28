package br.com.irvabank.validation;

import br.com.irvabank.model.ClienteEntity;
import br.com.irvabank.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
public class ClienteCadastroValidation implements Validator {

    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public boolean supports(Class<?> clazz) {return ClienteEntity.class.equals(clazz);}

    @Override
    public void validate(Object target, Errors errors) {
        ClienteEntity clienteEntity = (ClienteEntity) target;

        ClienteEntity cliente = clienteRepository.findByNumeroConta(clienteEntity.getNumeroConta());

        if (Objects.nonNull(cliente)) errors.reject("Cadastro Inválido", "Já existe cliente com esse número da conta.");
    }
}
