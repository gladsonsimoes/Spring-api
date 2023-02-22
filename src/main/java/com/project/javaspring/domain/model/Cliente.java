package com.project.javaspring.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.Name;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Cliente {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank //evitar null e branco
    @Size( max = 60 , min = 2) //definir o caractere maximo
    private String nome;

    @NotBlank
    @Email
    @Size( max = 255 )
    private String email;

    @NotBlank
    @Size( min = 11 , max = 14 )
    private String telefone;

}
