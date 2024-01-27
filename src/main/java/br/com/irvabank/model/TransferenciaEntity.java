package br.com.irvabank.model;

import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TB_TRANSFERENCIA")
@Data
public class TransferenciaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String contaOrigem;

    @Column(nullable = false, length = 255)
    private String contaDestino;

    @Column(nullable = false)
    @CreationTimestamp
    private Timestamp dataAgendamento;

    @Column(nullable = false)
    private Timestamp dataTransferencia;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private Double taxa;
}
