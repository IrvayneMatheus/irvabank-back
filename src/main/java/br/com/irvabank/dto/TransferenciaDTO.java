package br.com.irvabank.dto;

import java.io.Serializable;

import java.sql.Timestamp;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TransferenciaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotNull
    private String contaOrigem;
    @NotNull
    private String contaDestino;
    @NotNull
    private Timestamp dataAgendamento;
    @NotNull
    private Timestamp dataTransferencia;
    @NotNull
    private Double valor;
    @NotNull
    private Double taxa;
}