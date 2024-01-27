package br.com.irvabank.dto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;


@Data
public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotNull
    private String nome;
    @NotNull
    private String numeroConta;
}
