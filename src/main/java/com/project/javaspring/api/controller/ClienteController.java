package com.project.javaspring.api.controller;

import com.project.javaspring.domain.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @PersistenceContext
    private EntityManager manager;
    @GetMapping("/clientes")
    public List<Cliente> listar(){
    //Retornando Consulta da Tabela CLiente do Banco de dados com a classe resultante Cliente
        return manager.createQuery("from Cliente", Cliente.class)
        .getResultList();
    }
}
