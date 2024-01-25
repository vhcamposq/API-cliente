package io.github.vhcamposq.cliente.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 150)
    private String nome;
    @Column(nullable = false, length = 11)
    private String cpf;
    @Column
    private LocalDate dataCadastro;
}
