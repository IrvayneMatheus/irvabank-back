package br.com.irvabank.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Timestamp;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "TB_CLIENTE")
@Data
public class ClienteEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false, length = 255)
    private String numeroConta;

    @Column(updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    @Column(nullable = false)
    private Boolean active;

    @OneToMany(mappedBy="cliente", fetch= FetchType.LAZY)
    private List<TransferenciaEntity> transferencias;
}
